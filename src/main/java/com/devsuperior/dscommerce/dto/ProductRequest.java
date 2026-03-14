package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;
import jakarta.validation.constraints.*;

import java.util.Set;

public class ProductRequest {
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
    String name;

    @NotBlank(message = "Campo requerido")
    @Size(min = 10, message = "Descricao precisa ter no mínimo 10 caracteres")
    String description;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O preço deve ser positivo")
    Double price;

    String imgUrl;

    @NotEmpty(message = "Deve possuir no mínimo uma categoria")
    Set<CategorySumaryDTO> categories;

    public ProductRequest() {
    }

    public ProductRequest(String description, Double price, String imgUrl) {
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public Set<CategorySumaryDTO> getCategories() {
        return categories;
    }

    public void addCategorie(CategorySumaryDTO category) {
        this.categories.add(category);
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
