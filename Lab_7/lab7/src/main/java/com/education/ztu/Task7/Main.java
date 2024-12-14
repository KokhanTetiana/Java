package com.education.ztu.Task7;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int arraySize = 1000000;
        int[] array = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(10000);
        }

        long startTime = System.currentTimeMillis();
        long sumSingleThread = SingleThreadSum.sumDigitsSingleThread(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Однопотокова сума цифр: " + sumSingleThread);
        System.out.println("Час виконання в однопоточному режимі: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        long sumMultiThread = MultiThreadSum.sumDigitsMultiThread(array, 5);
        endTime = System.currentTimeMillis();
        System.out.println("Багатопотокова сума цифр: " + sumMultiThread);
        System.out.println("Час виконання в багатопоточному режимі: " + (endTime - startTime) + " мс");
    }
}
