package com.education.ztu;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first number: ");
        int first_number = in.nextInt();
        System.out.print("Input a second number: ");
        int second_number = in.nextInt();

        int sum = first_number + second_number;
        System.out.println("Sum: " + sum);
        in.close();
    }
}
