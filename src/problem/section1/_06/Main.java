package problem.section1._06;

import java.util.*;

class Main {
    public String solution(String str) {
        String answer = "";
        Set<Character> hash = new LinkedHashSet<>();

        for (Character c : str.toCharArray()) {
            hash.add(c);
        }

        for (Character c : hash) {
            answer += String.valueOf(c);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String duplicateString = kb.next();
        System.out.println(T.solution(duplicateString));
    }
}
