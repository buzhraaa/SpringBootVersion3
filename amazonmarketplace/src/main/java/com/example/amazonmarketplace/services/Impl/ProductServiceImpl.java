package com.example.amazonmarketplace.services.Impl;

import com.example.amazonmarketplace.dto.ProductDto;
import com.example.amazonmarketplace.mapper.ProductMapper;
import com.example.amazonmarketplace.models.Product;
import com.example.amazonmarketplace.repositories.ProductRepository;
import com.example.amazonmarketplace.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(productMapper::toDTO).orElse(null);
    }

    @Override
    public ProductDto updateProductPrice(Long id, Double newPrice) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setPrice(newPrice);
            Product updatedProduct = productRepository.save(product);
            return productMapper.toDTO(updatedProduct);
        }
        return null;
    }

    @Override
    public boolean deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ProductDto updateProductName(Long id, String newName) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newName);
                    return productMapper.toDTO(productRepository.save(product));
                })
                .orElse(null);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
}