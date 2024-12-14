package com.education.ztu.Task6;

import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Optional<Integer> maxNumber = Arrays.stream(numbers)
                .max(Integer::compareTo);

        String result = maxNumber
                .map(String::valueOf)
                .orElse("Числа відсутні");

        System.out.println(result);
    }
}
