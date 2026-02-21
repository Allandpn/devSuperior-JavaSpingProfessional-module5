package com.devsuperior.dscommerce.mappers;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductRequest;
import com.devsuperior.dscommerce.entities.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "name", target = "nomeProduto")
    ProductDTO toDTO(Product product);
    @Mapping(source = "nomeProduto", target = "name")
    Product toEntity(ProductRequest dto);

    @InheritConfiguration(name = "toEntity")
    void putProdutoFromDTO(ProductRequest dto, @MappingTarget Product entity);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void pathProdutoFromDTO(ProductRequest dto, @MappingTarget Product entity);

}
