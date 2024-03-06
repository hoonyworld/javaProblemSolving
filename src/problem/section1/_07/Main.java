package problem.section1._07;

import java.util.Scanner;

class Main {
    public String solution(String str) {
        String lowerStr = str.toLowerCase();
        StringBuilder reverseStrBuilder = new StringBuilder(lowerStr).reverse();

//        if (sb.reverse().toString() == sb.toString()) {
        if (lowerStr.equals(reverseStrBuilder.toString())) {
            return "YES";
        } else
            return "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String palindrome = kb.next();
        System.out.println(T.solution(palindrome));
    }
}
