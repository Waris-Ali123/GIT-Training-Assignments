package dev.basic;

public class PrintingPatterns {

    public static void main(String[] args) {
        int MaxStars = 10;

        String lineSeperator = "-".repeat(90);
        System.out.println(lineSeperator);
        System.out.println("Printing the Trianle in different patterns : ");
        System.out.println(lineSeperator);

//        printing the traingle
        for(int i=1;i<=MaxStars;i++){
            System.out.println(("* ".repeat(i)));
        }

        System.out.println(lineSeperator);

        for(int i=MaxStars;i>=1;i--){
            System.out.println(("* ".repeat(i)));
        }

        System.out.println(lineSeperator);
        for(int i=1;i<=MaxStars;i=i+2){
            System.out.println(" ".repeat(MaxStars-i) + "* ".repeat(i));
        }

        System.out.println(lineSeperator);
        for(int i=MaxStars;i>0;i=i-2){
            System.out.println(" ".repeat(MaxStars-i) + "* ".repeat(i));
        }

        System.out.println(lineSeperator);
        System.out.println("Printing Squares :");
        System.out.println(lineSeperator);

        for (int i = 0; i < MaxStars/2; i++) {
            System.out.println("* ".repeat(MaxStars));
        }
    }
}
