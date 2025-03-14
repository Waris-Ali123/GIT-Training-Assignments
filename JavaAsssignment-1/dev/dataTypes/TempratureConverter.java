package dev.dataTypes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TempratureConverter {

    static Scanner scanner = new Scanner(System.in);

    static String menu = """
            Welcome to the Temprature Converter by Waris..
            Please select from below:
            1 for Celsius To Fahrenheit,
            2 for Fahrenheit to Celsius
            Please enter your choice:
            """;

    private static double toFahrenheit(double celsius){
        return (celsius * 9 / 5) + 32;
    }

    private static double toCelsius(double fahrenheit){
        return (fahrenheit - 32) * 5 / 9;
    }
    public static void main(String[] args) {
        double tempratureInCelsius = 2;

        try {
            System.out.print(menu);
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Enter the temprature in Celsius:");
                    double celsius = scanner.nextInt();
                    System.out.printf("The temprature in Fahrenheit for the %.2f be %.2f\u2109", celsius, toFahrenheit(celsius));
                    break;
                case 2:
                    System.out.println("Enter the temprature in Fahrenheit:");
                    double fahrenheit = scanner.nextInt();
                    System.out.printf("The temprature in Celsius for the %.2f be %.2f\u2103", fahrenheit, toCelsius(fahrenheit));
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
