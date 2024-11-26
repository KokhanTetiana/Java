package com.education.ztu;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first number: ");
        int first_number = in.nextInt();
        System.out.print("Input a second number: ");
        int second_number = in.nextInt();

        int gcd = find(first_number, second_number);
        System.out.println("Greatest common divisor: " + gcd);
        in.close();
    }

    public static int find(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
