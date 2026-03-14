package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.CategorySumaryDTO;
import com.devsuperior.dscommerce.dto.ProductCatalogDTO;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductRequest;
import com.devsuperior.dscommerce.servicies.CategoryService;
import com.devsuperior.dscommerce.servicies.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @GetMapping()
    public ResponseEntity<List<CategorySumaryDTO>> findAll() {
        List<CategorySumaryDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

}
