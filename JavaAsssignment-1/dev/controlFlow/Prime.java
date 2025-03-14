package dev.controlFlow;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(System.in);
            System.out.print("Please enter a number to check whether it is prime or not : ");
            int input = sc.nextInt();
            boolean flag = true;
            for (int i = 2; i < input / 2; i++) {
                if (input % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.printf("%d is a prime number", input);
            else
                System.out.printf("%d is not a prime number", input);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}

