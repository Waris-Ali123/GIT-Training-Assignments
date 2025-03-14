package dev.stringManuplation;

public class ReverseStr {
    public static void main(String[] args) {
        String str = new String("WARIS ALI");
        System.out.println("Orignal String : " + str);
        System.out.println("-".repeat(90));
        System.out.println("One way is to iterate over string and add the characters to the start.");
        System.out.println("-".repeat(90));

        String reverseStr = "";

        for(char c:str.toCharArray()){
            reverseStr = c+reverseStr;
        }
        System.out.println("Reversed be : " + reverseStr);

        System.out.println("-".repeat(90));
        System.out.println("Another Way is to use String Builder reverse() method");
        System.out.println("-".repeat(90));
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println("Reversed String : "+ sb);
    }

}
