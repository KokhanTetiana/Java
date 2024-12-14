package com.education.ztu.Task3;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Predicate<String> isNumber = s -> {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        System.out.println(isNumber.test("123"));
        System.out.println(isNumber.test("abc"));

        Predicate<String> isNumberAndPositive = isNumber.and(s -> Integer.parseInt(s) > 0);
        System.out.println(isNumberAndPositive.test("123"));
        System.out.println(isNumberAndPositive.test("-123"));

        Consumer<String> startLesson = s -> System.out.println("Пара почалася о 8:30");
        Consumer<String> endLesson = s -> System.out.println("Пара закінчилася о 9:50");

        startLesson.andThen(endLesson).accept("Розклад");
        Supplier<String> sentence = () -> "вчимо java".toUpperCase();
        System.out.println(sentence.get());

        Function<String, Integer> productOfNumbers = s -> {
            String[] numbers = s.split(" ");
            int product = 1;
            for (String num : numbers) {
                product *= Integer.parseInt(num);
            }
            return product;
        };
        System.out.println(productOfNumbers.apply("1 2 3 4"));
    }
}
