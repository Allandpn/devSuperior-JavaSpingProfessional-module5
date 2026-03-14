package com.devsuperior.dscommerce.servicies;

import com.devsuperior.dscommerce.dto.CategorySumaryDTO;
import com.devsuperior.dscommerce.dto.ProductCatalogDTO;
import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;



    @Transactional(readOnly = true)
    public List<CategorySumaryDTO> findAll(){
        List<Category> result = categoryRepository.findAll();
        return result.stream().map(CategorySumaryDTO::new).toList();
    }


}
