package com.ecomercepro.e_commerce.repository;

import com.ecomercepro.e_commerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
