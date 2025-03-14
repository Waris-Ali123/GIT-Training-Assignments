package dev.stringManuplation;

public class VowelCounter {
    public static boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;

        return false;
    }
    public static void main(String[] args) {
        int vowelCount = 0;
        String str = "Hey there ! I am Waris Ali";
        for(char c : str.toCharArray()){
            if(isVowel(Character.toLowerCase(c))) vowelCount++;
        }

        System.out.printf("Above String contains %d vowels",vowelCount);
    }
}

