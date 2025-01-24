package com.ruturaj.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ruturaj.dao.ProductDAO;
import com.ruturaj.dao.impl.ProductDAOImpl;
import com.ruturaj.models.Product;
import com.ruturaj.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public void createProduct(Product product) {
        productDAO.createProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }

    @Override
    public List<Product> sortById(List<Product> productList) {
        return productDAO.sortById(productList);
    }

    @Override
    public List<Product> sortByProductName(List<Product> productList) {
        return productDAO.sortByProductName(productList);
    }

    @Override
    public List<Product> sortByProductPrice(List<Product> productList) {
        return productDAO.sortByProductPrice(productList);
    }

    @Override
    public List<Product> sortByProductQuantity(List<Product> productList) {
        return productDAO.sortByProductQuantity(productList);
    }

}
