package com.sena.barMJC.modules.product.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.barMJC.shared.json_view.Views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private String description;

    @JsonView(Views.Public.class)
    private String brand;

    @JsonView(Views.Internal.class)
    private Boolean status;

}
