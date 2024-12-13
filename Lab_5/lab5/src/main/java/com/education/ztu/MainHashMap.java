package com.education.ztu;

import java.util.HashMap;
import java.util.Map;

public class MainHashMap {
    public static void main(String[] args) {
        Map<String, Product> productMap = new HashMap<>();

        productMap.put("Cheese", new Product("Cheese", 70.20, 20));
        productMap.put("Juice", new Product("Juice", 45.00, 10));
        productMap.put("Yogurts", new Product("Yogurts", 28.50, 30));

        System.out.println("Get product by key 'Juice': " + productMap.get("Juice"));
        System.out.println("Contains 'Cheese' key: " + productMap.containsKey("Cheese"));
        productMap.remove("Yogurts");
        System.out.println("Map after removing 'Yogurts': " + productMap);
        System.out.println("Size of Map: " + productMap.size());
        System.out.println("Entries in the Map:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
