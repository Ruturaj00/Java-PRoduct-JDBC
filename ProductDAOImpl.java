package com.ruturaj.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ruturaj.dao.ProductDAO;
import com.ruturaj.models.Product;

public class ProductDAOImpl implements ProductDAO{
	private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root123";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @Override
    public void createProduct(Product product) {
        String query = "INSERT INTO products (product_id, product_name, product_description, price, quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setString(3, product.getProductDescription());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Product inserted successfully." : "Product insertion failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        String query = "UPDATE products SET product_name = ?, product_description = ?, price = ?, quantity = ? WHERE product_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getProductDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getProductId());
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Product updated successfully." : "Product update failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int productId) {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, productId);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Product deleted successfully." : "Product deletion failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> sortById(List<Product> products) {
        products.sort(Comparator.comparingInt(Product::getProductId));
        return products;
    }

    @Override
    public List<Product> sortByProductName(List<Product> products) {
        products.sort(Comparator.comparing(Product::getProductName));
        return products;
    }

    @Override
    public List<Product> sortByProductPrice(List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        return products;
    }

    @Override
    public List<Product> sortByProductQuantity(List<Product> products) {
        products.sort(Comparator.comparingInt(Product::getQuantity));
        return products;
    }}
