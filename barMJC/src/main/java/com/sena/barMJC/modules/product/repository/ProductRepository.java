package com.sena.barMJC.modules.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.barMJC.modules.product.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

    List<Product> findByName(String name);
    List<Product> findByBrand(String brand);

}
