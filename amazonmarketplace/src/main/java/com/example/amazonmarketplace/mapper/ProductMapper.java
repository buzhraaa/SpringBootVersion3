package com.example.amazonmarketplace.mapper;

import com.example.amazonmarketplace.dto.ProductDto;
import com.example.amazonmarketplace.models.Product;
import org.springframework.stereotype.Component;

/**
 * Mapper class to convert between Product entity and ProductDto.
 */

@Component
public class ProductMapper {
    /**
     * Converts a ProductDto to a Product entity.
     *
     * @param productDTO the ProductDto to convert
     * @return the converted Product entity
     */
    public Product toEntity(ProductDto productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    /**
     * Converts a Product entity to a ProductDto.
     *
     * @param product the Product entity to convert
     * @return the converted ProductDto
     */
    public ProductDto toDTO(Product product) {
        ProductDto productDTO = new ProductDto();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}