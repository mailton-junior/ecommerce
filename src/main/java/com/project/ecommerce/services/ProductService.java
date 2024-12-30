package com.project.ecommerce.services;

import com.project.ecommerce.dto.ProductDTO;
import com.project.ecommerce.entities.Product;
import com.project.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(@RequestBody ProductDTO dto) {
       Product entity = new Product();
       entity.setName(dto.getName());
       entity.setDescription(dto.getDescription());
       entity.setPrice(dto.getPrice());
       entity.setImgUrl(dto.getImgUrl());

       entity = repository.save(entity);

       return new ProductDTO(entity);
    }
}
