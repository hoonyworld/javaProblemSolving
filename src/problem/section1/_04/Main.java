package problem.section1._04;

import java.util.Scanner;
class Main {
    public String solution(String str) {
        String answer = "";
        char[] c = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            c[i] = str.charAt(i);
        }

        for (int i = str.length() - 1; i >= 0 ; i--) {
            answer += String.valueOf(c[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int count = kb.nextInt();
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = kb.next();
        }
        for (int i = 0; i < count; i++) {
            System.out.println(T.solution(arr[i]));
        }
    }
}


