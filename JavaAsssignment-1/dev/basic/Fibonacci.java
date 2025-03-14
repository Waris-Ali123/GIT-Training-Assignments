package dev.basic;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(System.in);
            System.out.print("Please enter a number to print the Fibonacci series upto :");
            int input = sc.nextInt();

            if (input <= 0) {
                System.out.println("Please enter a positive number");
            } else if (input == 1) {
                System.out.println("Fibonacci series: 0");
            } else {

                int f0 = 0;
                int f1 = 1;
                System.out.printf("Fibonacci Series: %d %d", f0,f1);
                int sum = 0;
                int count = 2;
                while (count < input) {
                    sum = f0 + f1;
                    f0 = f1;
                    f1 = sum;
                    System.out.printf(" %d", sum);
                    count++;
                }

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        } finally{
            sc.close();
        }
    }
}
