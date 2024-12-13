package com.education.ztu;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class MainTreeSet {
    public static void main(String[] args) {
        TreeSet<Product> productSet = new TreeSet<>(Comparator.comparingDouble(Product::getPrice));

        productSet.add(new Product("Cheese", 70.20, 20));
        productSet.add(new Product("Juice", 45.00, 10));
        productSet.add(new Product("Yogurts", 28.50, 30));
        productSet.add(new Product("Ice cream", 18.99, 5));

        Product searchProduct = new Product("", 45.00, 0);

        System.out.println("\nFirst product in the set: " + productSet.first());
        System.out.println("Last product in the set: " + productSet.last());

        System.out.println("\nProduct with price >= 45.00: " + productSet.ceiling(searchProduct));
        System.out.println("Product with price <= 45.00: " + productSet.floor(searchProduct));
        System.out.println("Product with price > 45.00: " + productSet.higher(searchProduct));
        System.out.println("Product with price < 45.00: " + productSet.lower(searchProduct));
    }
}
