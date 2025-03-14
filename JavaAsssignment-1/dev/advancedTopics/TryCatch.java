package dev.advancedTopics;

import java.util.Scanner;

public class TryCatch {
    public static <sc> void main(String[] args) {
        Scanner sc ;
        sc = new Scanner(System.in);

        //Using try-catch-finally block
        try {
            System.out.println("Enter the first number a : ");
            int a = sc.nextInt();
            System.out.println("Enter the second number b as a divisor: ");
            int b = sc.nextInt();
            int result = a / b;  //may have division by zero
        } catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }finally {
            sc.close();
            System.out.println("Resources has been removed.");
        }

        //Using try with resources
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Try to enter a non integer number :");
            scanner.nextInt();
        }catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }

    }
}
