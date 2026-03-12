package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.PersonDTO;
import com.devsuperior.dscommerce.dto.PersonDepartmentDTO;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductRequest;
import com.devsuperior.dscommerce.servicies.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/people")
public class PersonControler {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<PersonDepartmentDTO> insertProduct(@Valid @RequestBody PersonDepartmentDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "/person")
    public ResponseEntity<PersonDTO> insertProduct(@Valid @RequestBody PersonDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
