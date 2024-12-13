package com.education.ztu;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainQueue {
    public static void main(String[] args) {
        ArrayDeque<Product> queue = new ArrayDeque<>();

        queue.push(new Product("Cheese", 70.20, 20));
        queue.offerLast(new Product("Juice", 45.00, 10));

        System.out.println("First: " + queue.getFirst());
        System.out.println("Peek Last: " + queue.peekLast());

        queue.pop();
        System.out.println("After pop: " + queue);

        queue.removeLast();
        System.out.println("After removeLast: " + queue);
    }
}
