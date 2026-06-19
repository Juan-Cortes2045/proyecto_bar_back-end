package com.sena.barMJC.modules.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.barMJC.modules.product.dto.request.ProductCreateDTO;
import com.sena.barMJC.modules.product.dto.request.ProductUpdateDTO;
import com.sena.barMJC.modules.product.dto.response.ProductResponseDTO;
import com.sena.barMJC.modules.product.service.interfaces.ProductService;
import com.sena.barMJC.shared.AbstractCrudController.AbstractCrudController;
import com.sena.barMJC.shared.service.CrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController extends AbstractCrudController<ProductResponseDTO, ProductCreateDTO, ProductUpdateDTO, Long> {

    private final ProductService service;

    @Override
    protected CrudService<ProductResponseDTO, ProductCreateDTO, ProductUpdateDTO, Long> getService(){
        return service;
    }

}
