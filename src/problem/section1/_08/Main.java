package problem.section1._08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

class Main {
    public String solution(String str) {
//        char[] c = new char[str.length()];
        List<Character> onlyAlphabet = new ArrayList<>();
        for (char x : str.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(x)) {
                onlyAlphabet.add(x);
            }
        }

//        String s = String.valueOf(onlyAlphabet);
        StringJoiner sj = new StringJoiner("");
        for (Character c : onlyAlphabet) {
            sj.add(String.valueOf(c));
        }

        String s = sj.toString();
        StringBuilder sb = new StringBuilder(s);

        if (s.equals(sb.reverse().toString())) {
            return "YES";
        } else
            return "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String palindrome = kb.nextLine();
        System.out.println(T.solution(palindrome));
    }
}
