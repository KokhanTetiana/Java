package com.education.ztu;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input quantity of elements in the array: ");
        int quantity = in.nextInt();

        int[] fibonacci = new int[quantity];
        fibonacci[0] = 1;
        if (quantity > 1){
            fibonacci[1] = 1;
        }
        for (int i = 2; i < quantity; i++){
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        int[] reverseFibonacci = new int[quantity];
        for (int i = 0; i < quantity; i++){
            reverseFibonacci[i] = fibonacci[quantity - i - 1];
        }

        System.out.println("Growing numbers of fibonacci: ");
        for (int i = 0; i < quantity; i++){
            System.out.print(fibonacci[i] + " ");
        }
        System.out.println();

        System.out.println("Reverse numbers of fibonacci: ");
        for (int i = 0; i < quantity; i++){
            System.out.print(reverseFibonacci[i] + " ");
        }
        System.out.println();
        in.close();
    }
}
