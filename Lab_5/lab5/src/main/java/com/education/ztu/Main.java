package com.education.ztu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Cheese", 70.20, 20));
        products.add(new Product("Juice", 45.00, 10));
        products.add(new Product("Yogurts", 28.50, 30));
        products.add(new Product("Ice cream", 18.99, 5));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("=======================");
            System.out.println("1. Add a product");
            System.out.println("2. Remove a product by index");
            System.out.println("3. Display all products");
            System.out.println("4. Sort products by price");
            System.out.println("5. Get product by index");
            System.out.println("6. Display size of the list");
            System.out.println("7. Convert list to array and display");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    products.add(new Product(name, price, quantity));
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter index of product to remove: ");
                    int indexToRemove = scanner.nextInt();
                    if (indexToRemove >= 0 && indexToRemove < products.size()) {
                        products.remove(indexToRemove);
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    System.out.println("All products:");
                    for (Product product : products) {
                        product.displayInfo();
                        System.out.println("---------------");
                    }
                    break;

                case 4:
                    products.sort(Comparator.comparingDouble(Product::getPrice));
                    System.out.println("Products sorted by price:");
                    for (Product product : products) {
                        product.displayInfo();
                        System.out.println();
                    }
                    break;


                case 5:
                    System.out.print("Enter index to get product: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < products.size()) {
                        System.out.println("Product at index " + index + ": " + products.get(index).getName());
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 6:
                    System.out.println("Size of the list: " + products.size());
                    break;

                case 7:
                    Product[] productArray = products.toArray(new Product[0]);
                    System.out.println("Array of products:");
                    for (Product product : productArray) {
                        product.displayInfo();
                        System.out.println();
                    }
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}