package dev.arrays;

import java.util.Arrays;

public class SortingArray {

    public static void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortingMethod(int[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=i;j< arr.length;j++){
                if(arr[i]>arr[j]){
                    swap(i,j,arr);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,67,34,89,8,22,45,90,75,600,55};
        sortingMethod(nums);
        System.out.println("Sorted Array be : " + Arrays.toString(nums));
    }
}
