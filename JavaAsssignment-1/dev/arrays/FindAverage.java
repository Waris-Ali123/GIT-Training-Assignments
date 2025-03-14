package dev.arrays;

import java.util.Arrays;

public class FindAverage {

    public static void main(String[] args) {
        Integer[] numArr = new Integer[10];
        Arrays.setAll(numArr,i->i);
        System.out.println(Arrays.toString(numArr));

        int sum = 0;
        for (int i:numArr) {
            sum += i;
        }

        System.out.printf("Average of %s : %.2f ",Arrays.toString(numArr),(double) sum/numArr.length);
    }
}
