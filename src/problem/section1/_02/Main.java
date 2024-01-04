package problem.section1._02;

import java.util.Scanner;

class Main {
    public String solution(String str) {
        StringBuilder convertString = new StringBuilder(str);

        for (int i = 0; i < convertString.length(); i++) {
            char ch = convertString.charAt(i);
            if (Character.isLowerCase(ch)) {
                convertString.setCharAt(i, Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                convertString.setCharAt(i, Character.toLowerCase(ch));
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


