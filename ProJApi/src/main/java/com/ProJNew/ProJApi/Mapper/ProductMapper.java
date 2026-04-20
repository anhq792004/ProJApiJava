package com.ProJNew.ProJApi.Mapper;

import com.ProJNew.ProJApi.Dto.Request.ProductCreateRequest;
import com.ProJNew.ProJApi.Dto.Request.ProductUpdateRequest;
import com.ProJNew.ProJApi.Dto.Response.ProductResponse;
import com.ProJNew.ProJApi.Entities.Product;
import com.ProJNew.ProJApi.Entities.Properties.Brand;
import com.ProJNew.ProJApi.Entities.Properties.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    // ================= CREATE =================
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brand", source = "brandId", qualifiedByName = "mapBrand")
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategory")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product toEntity(ProductCreateRequest request);

    // ================= UPDATE =================
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brand", source = "brandId", qualifiedByName = "mapBrand")
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategory")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(ProductUpdateRequest request, @MappingTarget Product product);

    // ================= RESPONSE =================
    @Mapping(target = "brandId", source = "brand.id")
    @Mapping(target = "brandName", source = "brand.brandName")
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.categoryName")
    ProductResponse toResponse(Product product);

    // ================= CUSTOM MAPPING =================
    @Named("mapBrand")
    default Brand mapBrand(Long brandId) {
        if (brandId == null) return null;
        Brand brand = new Brand();
        brand.setId(brandId);
        return brand;
    }

    @Named("mapCategory")
    default Category mapCategory(Long categoryId) {
        if (categoryId == null) return null;
        Category category = new Category();
        category.setId(categoryId);
        return category;
    }
}
