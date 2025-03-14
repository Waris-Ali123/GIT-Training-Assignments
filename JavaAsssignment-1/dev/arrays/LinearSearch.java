package dev.arrays;

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1,67,34,89,8,22,45,90,75,600,55};
        int target = 55;

        boolean flag = false;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                flag = true;
                index = i;
                break;
            }
        }

//        System.out.printf("Element %d%s found in %s%s",target,flag?"":" not", Arrays.toString(nums),flag?" at index %d".formatted(index):"");
        if(flag) System.out.printf("Element %d found in %s at %s",target, Arrays.toString(nums),index);
        else System.out.printf("Element %d not found in %s",target, Arrays.toString(nums));

    }
}
