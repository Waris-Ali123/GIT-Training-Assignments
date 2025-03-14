package dev.stringManuplation;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "Mug";
        String str2 = "gum";

        int sumOfStr1 = 0;
        int sumOfStr2 = 0;

        for(char c : str1.toLowerCase().toCharArray()){
            sumOfStr1 += (int)c;
        }

        for(char c : str2.toLowerCase().toCharArray()){
            sumOfStr2 += (int)c;
        }

        if(sumOfStr1==sumOfStr2) {
            System.out.printf("'%s' with respect to '%s' is anagram",str1.toUpperCase(),str2.toUpperCase());
        }
        else{
            System.out.printf("'%s' with respect to '%s' is not an anagram",str1.toUpperCase(),str2.toUpperCase() );
        }
    }
}
