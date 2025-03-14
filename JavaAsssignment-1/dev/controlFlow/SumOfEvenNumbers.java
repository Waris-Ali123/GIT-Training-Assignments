package dev.controlFlow;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int count = 1;
        int sum = 0;
        while(count <= 10){
            if(count%2==0){
                sum += count;
            }
            count++;

        }
        System.out.printf("The sum of Integers from one to ten : %d ",sum);
    }
}
