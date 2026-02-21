package com.devsuperior.dscommerce.dto;

public record ProductDTO(
        Long id,
        String nomeProduto,
        String description,
        Double price,
        String imgUrl
) {}
