package dev.dataTypes;

public class Operators {
    public static void main(String[] args) {
        int a = 25;
        int b = 5;

        String lineSeparator  = "-".repeat(90);


        System.out.println(lineSeparator);
        System.out.println("Arithmatic Operators : ");
        System.out.println(lineSeparator);
        System.out.printf("Addition operator (+): %d%n",a+b);
        System.out.printf("Subtraction operator (-): %d%n",a-b);
        System.out.printf("Multiplication operator (*): %d%n",a*b);
        System.out.printf("Division operator (/): %.2f %n",(float) a/b);
        System.out.printf("Modulus operator (%%): %d%n",(int) a%b);

        System.out.println(lineSeparator);
        System.out.println("Logical Operators : ");
        System.out.println(lineSeparator);
        boolean b1 = true;
        boolean b2 = false;
        System.out.printf("AND operator (&&): %b%n",b1&&b2);
        System.out.printf("OR operator (||): %b%n",b1 || b2);
        System.out.printf("NOT operator (!): %b%n",!b1);

        System.out.println(lineSeparator);
        System.out.println("Relational Operators : ");
        System.out.println(lineSeparator);
        System.out.printf("Equal operator (==): %b%n",a==b);
        System.out.printf("Equal operator (!=): %b%n",a!=b);
        System.out.printf("Greater than operator (>): %b%n",a>b);
        System.out.printf("Greater than or Equal to operator (>=): %b%n",a>=b);
        System.out.printf("less than operator (<): %b%n",a<b);
        System.out.printf("less than or equal to operator (<=): %b%n",a<=b);

    }
}
