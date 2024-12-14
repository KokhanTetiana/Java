package com.education.ztu.Task7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadSum {
    public static long sumDigitsMultiThread(int[] array, int numberOfThreads) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        int chunkSize = array.length / numberOfThreads;
        List<Future<Long>> futures = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numberOfThreads - 1) ? array.length : (i + 1) * chunkSize;
            final int startIndex = start;
            final int endIndex = end;

            futures.add(executor.submit(() -> {
                long sum = 0;
                for (int j = startIndex; j < endIndex; j++) {
                    sum += sumDigits(array[j]);
                }
                return sum;
            }));
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
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
