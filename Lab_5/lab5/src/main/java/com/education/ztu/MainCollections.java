package com.education.ztu;

import java.util.*;

public class MainCollections {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Cheese", 70.20, 20),
                new Product("Juice", 45.00, 10),
                new Product("Yogurts", 28.50, 30)
        ));

        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Sorted by price: " + products);

        Collections.sort(products, Comparator.comparing(Product::getName));
        System.out.println("\nSorted by name: " + products);

        int index = Collections.binarySearch(products, new Product("Juice", 45.00, 0), Comparator.comparingDouble(Product::getPrice));
        System.out.println("\nBinary search for Juice by price: " + index);

        Collections.reverse(products);
        System.out.println("\nReversed list: " + products);

        Collections.shuffle(products);
        System.out.println("\nShuffled list: " + products);

        List<Product> fillList = new ArrayList<>(Arrays.asList(new Product[3]));
        Collections.fill(fillList, new Product("Default Product", 100.0, 0));
        System.out.println("\nFilled list: " + fillList);

        Product maxProduct = Collections.max(products, Comparator.comparingDouble(Product::getPrice));
        Product minProduct = Collections.min(products, Comparator.comparingDouble(Product::getPrice));
        System.out.println("\nMax price product: " + maxProduct);
        System.out.println("\nMin price product: " + minProduct);

        List<Product> copyList = new ArrayList<>(Arrays.asList(new Product[products.size()]));
        Collections.copy(copyList, products);
        System.out.println("\nCopied list: " + copyList);

        Collections.rotate(products, 2);
        System.out.println("\nRotated list: " + products);

        Collection<Product> checkedCollection = Collections.checkedCollection(products, Product.class);
        System.out.println("\nChecked collection: " + checkedCollection);

        int frequency = Collections.frequency(products, new Product("Juice", 45.00, 10));
        System.out.println("\nFrequency of Juice: " + frequency);
    }
}