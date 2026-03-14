package com.devsuperior.dscommerce.servicies;

import com.devsuperior.dscommerce.dto.ProductCatalogDTO;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductRequest;
import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.mappers.ProductMapper;
import com.devsuperior.dscommerce.repositories.CategoryRepository;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.servicies.exceptions.DatabaseException;
import com.devsuperior.dscommerce.servicies.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
        return productMapper.toDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductCatalogDTO> searchByName(String name, Pageable pageable){
        Page<Product> result = productRepository.searchByName(name, pageable);
        return result.map(x -> productMapper.toCatalogDTO(x));
    }

    @Transactional
    public ProductDTO insertProduct(ProductRequest productRequest){
        Product product = productMapper.toEntity(productRequest);
        updateCategory(product, productRequest.getCategories());
        product =  productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductRequest productRequest){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        productMapper.putProdutoFromDTO(productRequest, product);
        return productMapper.toDTO(product);
    }

    @Transactional
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        try {
            List<Category> categoryList =  product.getCategories().stream().toList();
            for(Category category : categoryList){
                category.removeProduct(product);
            }
            productRepository.flush();
            productRepository.delete(product);
            productRepository.flush();
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não é possível excluir pois há entidades relacionadas");
        }
    }


    // UTILS

    private void updateCategory(Product entity, Set<Long> categories){
        entity.getCategories().clear();
        for(Long c : categories){
            entity.addCategory(categoryRepository.getReferenceById(c));
        }
    }


//
//    public Page<ProductDTO> findAll(Pageable pageable) {
//        Page<Product> result = productRepository.findAll(pageable);
//        return result.map(productMapper::toDTO);
//    }
}
