package com.example.amazonmarketplace.services;

import com.example.amazonmarketplace.dto.ProductDto;
import java.util.List;

public interface ProductService {

    ProductDto getProductById(Long id);

    ProductDto updateProductPrice(Long id, Double newPrice);

    ProductDto updateProductName(Long id, String newName);

    boolean deleteProductById(Long id);

    List<ProductDto> getAllProducts();
}