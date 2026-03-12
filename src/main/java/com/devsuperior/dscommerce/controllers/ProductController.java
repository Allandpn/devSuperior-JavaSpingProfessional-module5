package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductRequest;
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

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;
//
//    @GetMapping
//    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){
//        Page<ProductDTO> dto = productService.findAll(pageable);
//        return ResponseEntity.ok(dto);
//    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO productDTO = productService.findById(id);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<Page<ProductDTO>> searchByName(@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable) {
        Page<ProductDTO> listProductsDTO = productService.searchByName(name, pageable);
        return ResponseEntity.ok(listProductsDTO);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductDTO> insertProduct(@Valid @RequestBody ProductRequest productRequest){
        ProductDTO productDTO = productService.insertProduct(productRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productDTO.id()).toUri();
        return ResponseEntity.created(uri).body(productDTO);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductDTO> updateById(@Valid @PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.updateProduct(id, productRequest));
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();

    }

}
