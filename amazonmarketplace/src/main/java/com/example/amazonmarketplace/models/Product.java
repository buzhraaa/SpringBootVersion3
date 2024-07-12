package com.example.amazonmarketplace.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a product in the Amazon Marketplace.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    /**
     * The unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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