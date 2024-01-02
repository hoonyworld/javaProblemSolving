package problem.section1._02;

import java.util.Scanner;

class Main {
    public String solution(String str) {
        StringBuilder convertString = new StringBuilder(str);
        String upperCaseString = str.toUpperCase();
        String lowerCaseString = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == upperCaseString.charAt(i)) {
                convertString.setCharAt(i, str.toLowerCase().charAt(i));
            } else if (str.charAt(i) == lowerCaseString.charAt(i)) {
                convertString.setCharAt(i, str.toUpperCase().charAt(i));
            }
        }
        return convertString.toString();
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}


