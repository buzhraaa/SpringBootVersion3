package com.example.amazonmarketplace.repositories;

import com.example.amazonmarketplace.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Product} entities.
 * Provides basic CRUD operations due to the extension of {@link JpaRepository}.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}