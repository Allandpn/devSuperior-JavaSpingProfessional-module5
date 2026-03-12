package com.devsuperior.dscommerce.dto;

import java.util.Set;

public record ProductDTO(

        Long id,
        String name,
        String description,
        Double price,
        String imgUrl,
        Set<CategorySumaryDTO> categories
) {}
