package com.ecomercepro.e_commerce.controller;

import com.ecomercepro.e_commerce.entity.Category;
import com.ecomercepro.e_commerce.entity.Product;
import com.ecomercepro.e_commerce.service.CategoryService;
import com.ecomercepro.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {


        @Autowired
        private CategoryService categoryService;


        // create all categories
        @PostMapping
        public Category createCategory(@RequestBody Category category) {
            return categoryService.createCategory(category);
        }

       // Get all categories
       @GetMapping
       public List<Category> getAllCategories() {

            return categoryService.getAllCategories();
       }

       //Get category by ID
       @GetMapping("/{id}")
       public Category getCategoryById(@PathVariable Integer id) {
          return categoryService.getCategoryById(id);
      }
    // Update category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category updatedCategory) {
        Category category = categoryService.updateCategory(id, updatedCategory);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    // Delete category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        if (categoryService.deleteCategory(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    // Get all products by category ID
    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategoryId(@PathVariable Integer id) {
        return categoryService.getProductsByCategoryId(id);
    }


}


