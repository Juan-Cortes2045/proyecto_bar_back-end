package com.sena.barMJC.modules.product.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private Boolean status;

}
