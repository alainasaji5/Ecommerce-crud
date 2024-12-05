package com.ecomercepro.e_commerce.service;

import com.ecomercepro.e_commerce.entity.Category;
import com.ecomercepro.e_commerce.entity.Product;
import com.ecomercepro.e_commerce.repository.CategoryRepository;
import com.ecomercepro.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    // create all category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    // Get all category
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    //get category by id
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Update category
    public Category updateCategory(Integer id, Category updatedCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            category.setDescription(updatedCategory.getDescription());
            return categoryRepository.save(category);
        }).orElse(null);
    }

    // Delete category
    public boolean deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    // Get products by category ID
    public List<Product> getProductsByCategoryId(Integer categoryId) {

        return productRepository.findByCategoryId(categoryId);
    }
}
