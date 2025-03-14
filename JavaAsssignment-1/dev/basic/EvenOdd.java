package dev.basic;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(System.in);
            System.out.print("Please enter a number to check whether it is even or odd:");
            int input = sc.nextInt();
            if (input % 2 == 0) {
                System.out.printf("%d is even", input);
            } else {
                System.out.printf("%d is odd", input);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
