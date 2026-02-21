package com.devsuperior.dscommerce.servicies;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductRequest;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.mappers.ProductMapper;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.servicies.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
        return productMapper.toDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(x -> productMapper.toDTO(x));
    }

    @Transactional
    public ProductDTO insertProduct(ProductRequest productRequest){
        Product product = productMapper.toEntity(productRequest);
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
        productRepository.deleteById(id);
    }
}
