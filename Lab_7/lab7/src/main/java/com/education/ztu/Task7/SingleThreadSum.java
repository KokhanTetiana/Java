package com.education.ztu.Task7;

public class SingleThreadSum {
    public static long sumDigitsSingleThread(int[] array) {
        long sum = 0;
        for (int num : array) {
            sum += sumDigits(num);
        }
        return sum;
    }

    private static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
