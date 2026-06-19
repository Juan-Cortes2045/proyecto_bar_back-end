package com.sena.barMJC.modules.product.validator;

import org.springframework.stereotype.Component;

import com.sena.barMJC.modules.product.dto.request.ProductCreateDTO;

@Component
public class ProductValidator {

    public void validate(ProductCreateDTO dto) {

        if (dto.getName() == null ||
            dto.getName().trim().isEmpty()) {

            throw new RuntimeException(
                "Product name is required"
            );
        }

        if (dto.getBrand() == null ||
            dto.getBrand().trim().isEmpty()) {

            throw new RuntimeException(
                "Product brand is required"
            );
        }
    }
}