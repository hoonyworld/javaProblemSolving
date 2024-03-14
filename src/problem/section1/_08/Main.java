package problem.section1._08;

import java.util.Scanner;

class Main {
    public String solution(String str) {
        String answer = "NO";
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        String reverseSentence = new StringBuilder(str).reverse().toString();

        if (str.equals(reverseSentence)){
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String palindrome = kb.nextLine();
        System.out.println(T.solution(palindrome));
    }
}
