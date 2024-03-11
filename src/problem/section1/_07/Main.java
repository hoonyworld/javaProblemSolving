package problem.section1._07;

import java.util.Scanner;

class Main {
    public String solution(String str) {
        String answer = "NO";
        StringBuilder reverseStrBuilder = new StringBuilder(str).reverse();

        if (str.equalsIgnoreCase(reverseStrBuilder.toString())) {
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String palindrome = kb.next();
        System.out.println(T.solution(palindrome));
    }
}
