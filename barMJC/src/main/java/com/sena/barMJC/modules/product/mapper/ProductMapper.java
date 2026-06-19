package com.sena.barMJC.modules.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.sena.barMJC.modules.product.dto.request.ProductCreateDTO;
import com.sena.barMJC.modules.product.dto.request.ProductUpdateDTO;
import com.sena.barMJC.modules.product.dto.response.ProductResponseDTO;
import com.sena.barMJC.modules.product.entity.Product;

@Mapper(componentModel= "spring")
public interface ProductMapper {

    Product toEntity(ProductCreateDTO dto);

    ProductResponseDTO toResponse(Product product);

    void updateEntityFromDto(
        ProductUpdateDTO dto,
        @MappingTarget Product product
    );

}
