package problem.section1._05;

import java.util.*;

class Main {
    public String solution(String str){
        StringBuilder sb = new StringBuilder(str);
        int lt = 0;
        int rt = sb.length() - 1;
        while(lt < rt){
            if(!Character.isAlphabetic(sb.charAt(lt))) {
                lt++;
            } else if (!Character.isAlphabetic(sb.charAt(rt))) {
                rt--;
            } else {
                char temp = sb.charAt(lt);
                sb.setCharAt(lt, sb.charAt(rt));
                sb.setCharAt(rt, temp);
                lt++;
                rt--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
