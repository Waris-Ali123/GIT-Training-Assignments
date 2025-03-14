package dev.basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Area {

    static Scanner scanner = new Scanner(System.in);

    static String menu = """
            Welcome to the Area Finder by Waris..
            Please select from below:
            1 for Circle,
            2 for Rectangle,
            3 for Triangle.
            Please enter your choice:
            """;

    private static double findArea(double radius) {
        return 3.14 * radius * radius;
    }

    private static double findArea(double length, double width) {
        return length * width;
    }

    private static double findTraingleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {

        try {
            System.out.print(menu);
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Enter the Radius of Circle:");
                    double radius = scanner.nextInt();
                    System.out.printf("The area of circle for the %.2f is %.2f", radius, findArea(radius));
                    break;
                case 2:
                    System.out.println("Enter the length of Rectangle:");
                    double length = scanner.nextInt();
                    System.out.println("Enter the Width of Rectangle:");
                    double width = scanner.nextInt();
                    System.out.printf("The area of Rectangle for length:%.2f width:%2f is %.2f", length, width, findArea(length, width));
                    break;
                case 3:
                    System.out.println("Enter the length of Triangle:");
                    double base = scanner.nextInt();
                    System.out.println("Enter the Width of Rectangle:");
                    double height = scanner.nextInt();
                    System.out.printf("The area of Triangle for base:%.2f height:%2f is %.2f", base, height, findTraingleArea(base, height));
                    break;
                default:
                    System.out.println("Invalid Option..!!");
            }
        } catch (InputMismatchException in) {
            System.out.println("Invalid Input Format found..!!");
            System.out.println(in.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            scanner.close();
        }

    }
}
