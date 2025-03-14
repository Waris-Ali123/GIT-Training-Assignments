package dev.controlFlow;

import java.util.Scanner;

public class LargestOfThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(System.in);

            System.out.println("Enter three numbers : ");
            System.out.print("Please enter 1st number: ");
            int num1 = sc.nextInt();
            System.out.print("Please enter 2nd number: ");
            int num2 = sc.nextInt();
            System.out.print("Please enter 3rd number: ");
            int num3 = sc.nextInt();

            int largest = Integer.MIN_VALUE;
            if(largest<num1) {
                largest = num1;
            }
            if(largest<num2) {
                largest = num2;
            }
            if(largest<num3) {
                largest = num3;
            }

            System.out.printf("Largest Number : %d",largest);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}

