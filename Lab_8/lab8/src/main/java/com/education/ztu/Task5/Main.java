package com.education.ztu.Task5;

import com.education.ztu.Task4.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<com.education.ztu.Task4.Product> products = Arrays.asList(
                new com.education.ztu.Task4.Product("TV", "LG", 15000.00, 20),
                new com.education.ztu.Task4.Product("Mobile", "Samsung", 7300.00, 100),
                new com.education.ztu.Task4.Product("MacBook", "Apple", 35999.00, 10),
                new com.education.ztu.Task4.Product("Headphones", "Samsung", 500.00, 50),
                new Product("Phone case", "Apple", 925.00, 300)
        );

        System.out.println("All brands:");
        products.stream()
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);


        System.out.println("\nProducts with price less than 1000 (limited to 2):");
        products.stream()
                .filter(product -> product.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);


        int totalCount = products.stream()
                .mapToInt(Product::getCount)
                .reduce(0, Integer::sum);
        System.out.println("\nTotal count of products: " + totalCount);


        System.out.println("\nProducts grouped by brand:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand));
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println(brand + ": " + productList);
        });


        System.out.println("\nProducts sorted by price:");
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
        sortedProducts.forEach(System.out::println);


        System.out.println("\nProducts with price between 500 and 15000:");
        products.stream()
                .filter(product -> product.getPrice() >= 500 && product.getPrice() <= 15000)
                .forEach(System.out::println);
    }
}
