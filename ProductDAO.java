package com.ruturaj.dao;

import java.util.List;

import com.ruturaj.models.Product;

public interface ProductDAO {
	void createProduct(Product product);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> sortById(List<Product> products);
    List<Product> sortByProductName(List<Product> products);
    List<Product> sortByProductPrice(List<Product> products);
    List<Product> sortByProductQuantity(List<Product> products);}
