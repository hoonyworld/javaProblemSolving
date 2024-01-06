package problem.section1._03;

import java.util.Scanner;

class Main {
    public String solution(String str) {
//        String madeStr = str + " ";
//        String answer;
//        int first = 0;
//        int move = 0;
//        int length = 0;
//
//        for (int i = 0; i < madeStr.length(); i++) {
//            if(madeStr.charAt(i) == ' ') {
//                int checkLength = madeStr.substring(move, i).length();
//                if (checkLength > length) {
//                    length = checkLength;
//                    first = move;
//                }
//                move = i + 1;
//            }
//        }
//
//        answer = madeStr.substring(first, first + length);
//        return answer;

        String[] arr = str.split(" ");
        String answer = "";
        int maxLength = Integer.MIN_VALUE;

        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                answer = s;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
