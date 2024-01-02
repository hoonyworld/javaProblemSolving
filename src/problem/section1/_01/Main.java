package problem.section1._01;

import java.util.Scanner;

class Main {
    public int solution(String str, char t) {
        int count = 0;
        str = str.toLowerCase();
        t = Character.toLowerCase(t);

        for (char criteria : str.toCharArray()) {
            if (criteria == t) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}