package com.example.springboot.controllers;

import com.example.springboot.domain.product.ProductRecordDto;
import com.example.springboot.domain.product.ProductModel;
import com.example.springboot.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(productRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        var productsList = productService.getAllProducts();
        productsList.forEach(product ->
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(product.getIdProduct())).withSelfRel())
        );
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getOneProduct(@PathVariable UUID id) {
        var product = productService.getOneProduct(id);
        product.add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable UUID id,
                                                      @RequestBody @Valid ProductRecordDto productRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, productRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}