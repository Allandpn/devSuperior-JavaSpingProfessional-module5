package com.devsuperior.dscommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class ProductRequest {
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
    String name;

    @NotBlank(message = "Campo requerido")
    @Size(min = 10, message = "Descricao precisa ter no mínimo 10 caracteres")
    String description;

    @PositiveOrZero(message = "O preço deve ser positivo")
    Double price;

    String imgUrl;

    @NotEmpty
    Set<Long> categories;

    public ProductRequest() {
    }

    public ProductRequest(String description, Double price, String imgUrl, Set<Long> categories) {
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public Set getCategories() {
        return categories;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
