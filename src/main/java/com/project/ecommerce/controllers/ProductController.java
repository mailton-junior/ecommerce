package com.project.ecommerce.controllers;

import com.project.ecommerce.dto.ProductDTO;
import com.project.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController  {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    private ProductDTO findByid(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    private Page<ProductDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

}
