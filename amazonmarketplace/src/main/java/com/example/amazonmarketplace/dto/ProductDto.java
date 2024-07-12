package com.example.amazonmarketplace.dto;

import lombok.Data;

/**
 * Data Transfer Object for Product.
 * This class is used to transfer product data between processes.
 */

@Data
public class ProductDto {
    /**
     * The unique identifier for the product.
     */
    private Long id;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * A description of the product.
     */
    private String description;

    /**
     * The price of the product.
     */
    private Double price;
}