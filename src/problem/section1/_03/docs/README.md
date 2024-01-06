# Problem - 문장 속 단어

## KeyWord
- 인덱스 위치 저장
- 구분 방식

## Problem Requirements
- 한 개의 문장이 입력되면, 그 문장에서 가장 긴 단어를 찾아 출력
- 만약 가장 긴 단어가 여러개이면 가장 앞쪽에 위치한 단어를 출력
- 단어는 공백으로 구분되며 모두 알파벳으로만 구성



## Problem Approach Strategy
### 기존전략
- str.charAt(i) == ' ' 으로 공백을 체크하여, str.substring(바로 전의 공백 index + 1, 현재 공백 index)으로 문자열(단어) 추출
- 문자열 추출시 .length()로 길이를 추출해서 현재 가장 긴 문자열(단어)의 길이가 저장되어 있는 변수와 길이 비교 후 더 클 경우 change.
- 또한 가장 긴 문자열의 시작 index를 저장해서 최종적으로 출력할때, substring(i, i + length) 만큼 출력

### 수정전략
- 가장 긴 문자열(단어)가 마지막에 있는 경우 공백 체크가 불가능 하였음. (마찬가지로 개행 체크도 불가능).
  - 따라서 기존 문자열 마지막에 공백(" ")을 붙여 새로운 String 객체를 생성해 이를 이용하였음.
- 처음에 index를 move라는 변수 하나로만 체크했으나, 가장 길이가 긴 문자열의 시작 index를 저장하지 못하게 되는 상황이 발생함
  - 따라서 first라는 정수형 변수 한개를 추가로 생성해, 가장 길이가 긴 문자열의 시작 index를 저장하도록 설계하였음.

## My Solution

```java
import java.util.Scanner;

class Main {
  public String solution(String str) {
    String madeStr = str + " ";
    String answer;
    int first = 0;
    int move = 0;
    int length = 0;

    for (int i = 0; i < madeStr.length(); i++) {
      if(madeStr.charAt(i) == ' ') {
        int checkLength = madeStr.substring(move, i).length();
        if (checkLength > length) {
          length = checkLength;
          first = move;
        }
        move = i + 1;
      }
    }

    answer = madeStr.substring(first, first + length);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();
    System.out.println(T.solution(str));
  }
}
```

## Model Solution

```java
import java.util.*;
class Main {
  public String solution(String str){
    String answer="";
//    int m=Integer.MIN_VALUE, pos;
//    while((pos=str.indexOf(' '))!=-1){
//      String tmp=str.substring(0, pos);
//      int len=tmp.length();
//      if(len>m){
//        m=len;
//        answer=tmp;
//      }
//      str=str.substring(pos+1);
//    }
//    if(str.length()>m) answer=str;
//    return answer;
    int m=Integer.MIN_VALUE;
    String[] s = str.split(" ");
    for(String x : s){
      int len=x.length();
      if(len>m){
        m=len;
        answer=x;
      }
    }
    return answer;
  }
  

  public static void main(String[] args){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    String str=kb.nextLine();
    System.out.print(T.solution(str));
  }
}
```

## Refactoring
```java
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
```
1. 원본 문자열 유지 여부
- 본인은 원본 문자열을 유지하고 가장 길이가 긴 문자열의 시작 index를 저장할 수 있도록 설계
- 김태원 강사님의 방식2(indexOf와 substring)는 check한 문자열은 잘라내고 새로운 문자열 객체를 계속 생성하여 가장 길이가 긴 문자열을 저장할 수 있도록 설계
- 결론 : substring을 사용한 방식에 한해서는 내 방법이 더 직관적이고 메모리 관리에 더 수월하다고 생각된다. 김태원 강시님의 방식은 기존 문자열을 잘라내고 새로운 문자열을 생성하는 방식인데, 나는 기존 문자열에 대해서 인덱스 연산만 수행하므로 메모리 효율성이 더 높기 때문이다.

2. 마지막 문자열(단어) 처리
- 본인은 원본 문자열 + " "을 추가한 새로운 문자열 객체를 생성해 이를 이용함으로서 기존 로직에서도 사용가능하도록 설계
- 김태원 강사님의 방식2(indexOf와 substring)은 마지막 문자열(단어)의 길이를 check하는 부분을 if문이 끝난 후에 체크하도록 설계
- 결론 : 내 방식이 보다 더 편리하다고 생각된다. 따라서 이 아이디어를 실전에서 떠올릴 수 있도록 기록해두자. 

3. 알아두면 편리한 split
- 위의 방식은 split이 없다고 가정했을 때에는 유용할 수 있지만, 결국 split을 사용하면 훨씬 간단하게 생각 가능
- 결론 : "무언가"를 기준으로 구분, "무언가"로 구분 이라는 문장이 있으면 "split을 써볼까?"하고 먼저 생각하자.

### 리팩토링 방향
- 강사님의 방식과 유사했고, 주관적으로 판단하에 더 유용한 부분도 있었다. 때문에 기존 코드의 로직이 괜찮다고 생각하여 리팩토링을 진행하지 않았다. 추후에 실력이 향상되어 코드를 다시 봤을 때 리팩토링을 할 부분이 보인다면, 그때 리팩토링을 해볼 생각이다.
- 대신 배운 split을 활용해서 코드 로직을 간편하게 구현해보는 방향으로 리팩토링을 하였다. (기존 코드는 주석처리)

## What I Learned
- "무언가"를 기준으로 분리한다면, 가장 먼저 split을 적용할 수 있을지를 판단하자.
- indexOf(), substring(), Integer.MIN_VALUE/MAX_VALUE 오늘 배운 메서드 및 변수다 역시 외워두자.