package com.devsuperior.dscommerce.dto;

import java.util.Set;

public record ProductCatalogDTO(

        Long id,
        String name,
        Double price,
        String imgUrl
) {}
