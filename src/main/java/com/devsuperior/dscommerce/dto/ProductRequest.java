package com.devsuperior.dscommerce.dto;

public record ProductRequest (
        String nomeProduto,
        String description,
        Double price,
        String imgUrl
){}
