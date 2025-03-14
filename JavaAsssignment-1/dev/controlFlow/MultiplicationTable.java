package dev.controlFlow;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(System.in);
            System.out.print("Please enter a number to git it's table: ");
            int input = sc.nextInt();

            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d * %d = %d %n",input,i,input*i);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
