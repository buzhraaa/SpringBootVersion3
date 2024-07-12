package com.example.amazonmarketplace.controllers;

import com.example.amazonmarketplace.dto.ProductDto;
import com.example.amazonmarketplace.services.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Cleint get 404 when trying to retrieve an id that does not exist
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        } else {
            String response = "Product with id " + id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Update the price of product
    @PatchMapping("/{id}/price")
    public ResponseEntity<ProductDto> updateProductPrice(@PathVariable Long id, @RequestParam Double newPrice) {
        ProductDto updatedProductDto = productService.updateProductPrice(id, newPrice);
        return updatedProductDto != null ? ResponseEntity.ok(updatedProductDto) : ResponseEntity.notFound().build();
    }

    // Update the name of the product
    @PatchMapping("/{id}/name")
    public ResponseEntity<ProductDto> updateProductName(@PathVariable Long id, @RequestParam String newName) {
        return ResponseEntity.ok(productService.updateProductName(id, newName));
    }

    // Dlete a product by its Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProductById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Get All the products
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}