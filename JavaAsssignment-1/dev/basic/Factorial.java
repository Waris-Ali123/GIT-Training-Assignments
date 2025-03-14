package dev.basic;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(System.in);
            System.out.print("Please enter a number to find its factorial:");
            int input = sc.nextInt();
            int storingInput = input;
            long result = 1 ;
            while(input>0){
                result *= input;
                input--;
            }
            System.out.printf("Factorial of %d is %d",storingInput ,result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
