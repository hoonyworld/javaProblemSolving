package problem.section1._04;

import java.util.*;

class Main {
    public ArrayList<String> solution(String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int count = kb.nextInt();
        String[] str = new String[count];
        for(int i = 0; i < count; i++) {
            str[i] = kb.next();
        }
        for(String x : T.solution(str)) {
            System.out.println(x);
        }
    }
}