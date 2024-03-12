package problem.section1._09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public String solution(String str) {
        String answer = "";
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                list.add(str.charAt(i));
            }
        }

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != '0') {
                index = i;
                break;
            }
        }

//        for (int i = 0; i < index; i++) {
//            if (list.get(i) == '0') {
//                list.remove(i);
//            }
//        }
        while (list.get(0) == '0') {
            list.remove(0);
        }

        for (int i = 0; i < list.size(); i++) {
            answer += String.valueOf(list.get(i));
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
