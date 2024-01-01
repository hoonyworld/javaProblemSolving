package section1._01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String generalString = sc.next();
        String strLowerCase = sc.next().toLowerCase();

        char[] arr = new char[generalString.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generalString.charAt(i);
        }
        char criteriaLowerCase = strLowerCase.charAt(0);
        char criteriaUpperCase = strLowerCase.toUpperCase().charAt(0);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == criteriaLowerCase || arr[i] == criteriaUpperCase) {
                count++;
            }
        }
        System.out.println(count);
    }
}