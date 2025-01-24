package com.ruturaj.service;

import java.util.List;

import com.ruturaj.models.Product;

public interface ProductService {
	void createProduct(Product product);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> sortById(List<Product> productList);
    List<Product> sortByProductName(List<Product> productList);
    List<Product> sortByProductPrice(List<Product> productList);
    List<Product> sortByProductQuantity(List<Product> productList);
}
