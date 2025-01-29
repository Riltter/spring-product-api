package com.example.springboot.services;

import com.example.springboot.domain.product.ProductRecordDto;
import com.example.springboot.domain.exceptions.BadRequestException;
import com.example.springboot.domain.exceptions.ResourceNotFoundException;
import com.example.springboot.domain.product.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductModel saveProduct(ProductRecordDto productRecordDto) {
        if (productRepository.existsByName(productRecordDto.name())) {
            throw new BadRequestException("Product with name '" + productRecordDto.name() + "' already exists.");
        }

        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
    }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductModel getOneProduct(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found."));
    }

    public ProductModel updateProduct(UUID id, ProductRecordDto productRecordDto) {
        var productModel = getOneProduct(id);
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
    }

    public void deleteProduct(UUID id) {
        var productModel = getOneProduct(id);
        productRepository.delete(productModel);
    }
}


