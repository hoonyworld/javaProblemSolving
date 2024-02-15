package problem.section1._05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder(str);
        List<Integer> nonAlphabetIndex = new ArrayList<>();
        List<Character> nonAlphabet = new ArrayList<>();

        String regex = "^[a-zA-Z]$";

        //  특수문자와 특수문자 위치 저장
        for (int i = 0; i < sb.length(); i++) {
            if(!Character.toString(sb.charAt(i)).matches(regex)) {
                nonAlphabetIndex.add(i);
                nonAlphabet.add(sb.charAt(i));
            }
        }

        // 특수문자 삭제
        for (int i = nonAlphabetIndex.size()-1; i >= 0; i--) {
            sb.deleteCharAt(nonAlphabetIndex.get(i));
        }

        // 새로운 문자열으로 swap
        int lt = 0;
        int rt = sb.length() - 1;
        while (lt < rt) {
            char temp = sb.charAt(lt);
            sb.setCharAt(lt, sb.charAt(rt));
            sb.setCharAt(rt, temp);
            lt++;
            rt--;
        }

        // swap 완료된 문자열에 특수문자 끼어넣기
        for (int i = 0; i < nonAlphabetIndex.size(); i++) {
            sb.insert(nonAlphabetIndex.get(i), nonAlphabet.get(i).toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
