package com.education.ztu;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a positive number: ");
        int number = in.nextInt();
        int sum = sumDijits(number);
        System.out.println("Sum of digits: " + sum);
        in.close();
    }

    public static int sumDijits(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
