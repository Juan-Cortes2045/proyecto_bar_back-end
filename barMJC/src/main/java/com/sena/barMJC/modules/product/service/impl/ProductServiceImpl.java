package com.sena.barMJC.modules.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.barMJC.modules.product.dto.request.ProductCreateDTO;
import com.sena.barMJC.modules.product.dto.request.ProductUpdateDTO;
import com.sena.barMJC.modules.product.dto.response.ProductResponseDTO;
import com.sena.barMJC.modules.product.entity.Product;
import com.sena.barMJC.modules.product.mapper.ProductMapper;
import com.sena.barMJC.modules.product.repository.ProductRepository;
import com.sena.barMJC.modules.product.service.interfaces.ProductService;
import com.sena.barMJC.modules.product.validator.ProductValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ProductValidator validator;

    @Override
    public List<ProductResponseDTO> findAll() {

        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ProductResponseDTO findById(Long id) {

        Product product = repository.findById(id).orElseThrow(() ->
                        new RuntimeException("Product not found"));

        return mapper.toResponse(product);
    }

    @Override
    public ProductResponseDTO create(ProductCreateDTO dto) {

        validator.validate(dto);

        Product product = mapper.toEntity(dto);

        Product saved = repository.save(product);

        return mapper.toResponse(saved);
    }

    @Override
    public ProductResponseDTO update(Long id, ProductUpdateDTO dto) {

        Product product = repository.findById(id).orElseThrow(() ->
                        new RuntimeException("Product not found"));

        mapper.updateEntityFromDto(dto, product);

        Product updated = repository.save(product);

        return mapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {

        Product product = repository.findById(id).orElseThrow(() ->
                        new RuntimeException("Product not found"));

        repository.delete(product);
    }
}
