package com.ruturaj.test;

import java.util.List;
import java.util.Scanner;

import com.ruturaj.models.Product;
import com.ruturaj.service.ProductService;
import com.ruturaj.service.impl.ProductServiceImpl;

public class TestProductSorting {
	public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();

        // Add 10 products to the list
        productService.createProduct(new Product(1, "Laptop", "Gaming Laptop", 1200.50, 5));
        productService.createProduct(new Product(2, "Smartphone", "Latest Model", 800.99, 15));
        productService.createProduct(new Product(3, "Headphones", "Noise Cancelling", 150.00, 50));
        productService.createProduct(new Product(4, "Monitor", "4K Display", 300.75, 20));
        productService.createProduct(new Product(5, "Keyboard", "Mechanical", 99.99, 30));
        productService.createProduct(new Product(6, "Mouse", "Wireless", 49.99, 40));
        productService.createProduct(new Product(7, "Chair", "Ergonomic", 199.95, 10));
        productService.createProduct(new Product(8, "Desk", "Adjustable Height", 299.00, 8));
        productService.createProduct(new Product(9, "Tablet", "10-inch Display", 250.00, 12));
        productService.createProduct(new Product(10, "Smartwatch", "Fitness Tracker", 199.99, 25));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nProduct Sorting Menu:");
            System.out.println("1. Sort by Product ID");
            System.out.println("2. Sort by Product Name");
            System.out.println("3. Sort by Product Price");
            System.out.println("4. Sort by Product Quantity");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            List<Product> products = productService.getAllProducts();

            switch (choice) {
                case 1:
                    productService.sortById(products);
                    products.forEach(System.out::println);
                    break;
                case 2:
                    productService.sortByProductName(products);
                    products.forEach(System.out::println);
                    break;
                case 3:
                    productService.sortByProductPrice(products);
                    products.forEach(System.out::println);
                    break;
                case 4:
                    productService.sortByProductQuantity(products);
                    products.forEach(System.out::println);
                    break;
                case 5:
                    products.forEach(System.out::println);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
