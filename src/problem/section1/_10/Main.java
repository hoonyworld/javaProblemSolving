package problem.section1._10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public String solution(String str, char c) {
        int distance = 0;
        List<Integer> indexOfStandard = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                indexOfStandard.add(i); // 1, 5, 10
            }
        }

        double[] avg = new double[indexOfStandard.size() - 1];  // 2
        int[] arr = new int[str.length()];
        for (int i = 0; i < avg.length; i++) {
            avg[i] = (indexOfStandard.get(i) + indexOfStandard.get(i + 1)) / 2.0;
        }

        // 1 ,5, 10, 총 2번 반복
        for (int i = 0; i < avg.length; i++) {
            // 1 ~ 3, 5 ~ 7
            for (int j = indexOfStandard.get(i); j <= (int)avg[i]; j++) {
                arr[j] = distance;
                distance++;
            }

            distance--;
            // 4, 8~9
            for (int j = (int)avg[i] + 1; j < indexOfStandard.get(i + 1); j++) {
                if (avg[i] % 1 == 0.0) {
                    distance--;
                    arr[j] = distance;
                } else {
                    arr[j] = distance;
                    distance--;
                }
            }
            distance = 0;
        }

        // 처음 등장한 e 전 까지 거리
        for (int i = str.indexOf(c); i >= 0 ; i--) {
            arr[i] = distance;
            distance++;
        }

        distance = 0;
        // 마지막 등장한 e 후의 거리
        for (int i = str.lastIndexOf(c); i < str.length(); i++) {
            arr[i] = distance;
            distance++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}
