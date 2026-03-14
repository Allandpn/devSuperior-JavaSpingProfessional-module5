package com.devsuperior.dscommerce.mappers;

import com.devsuperior.dscommerce.dto.CategorySumaryDTO;
import com.devsuperior.dscommerce.dto.ProductCatalogDTO;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.dto.ProductRequest;
import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProductMapper {
    ProductDTO toDTO(Product product);

    ProductCatalogDTO toCatalogDTO(Product product);

    CategorySumaryDTO toCategorySumaryDTO(Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "items", ignore = true)
    @Mapping(target = "order", ignore = true)
    Product toEntity(ProductRequest dto);

    @InheritConfiguration(name = "toEntity")
    void putProdutoFromDTO(ProductRequest dto, @MappingTarget Product entity);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void pathProdutoFromDTO(ProductRequest dto, @MappingTarget Product entity);

    // HELPERS
//    default Category map(Category category){
//        return new Category(category.getName(), category.getId());
//    }
}
