# Problem - 단어 뒤집기

## KeyWord

- LIFO
- 2차원 배열

## Problem Requirements

- 첫줄에 자연수 N이 주어지고, 두번째 줄부터 N개의 단어가 각 줄에 하나씩 주어짐.
- N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력.

## Problem Approach Strategy
### 기존전략
- 각 줄에 있는 단어의 길이가 다르기 때문에, 2차원 배열로 관리
- for문 순회
    - char형 배열에 각 문자열이 저장이 완료되면, i = 마지막 문자 인덱스 부터 i > 0 까지 순서대로 출력
    - 마지막 문자 인덱스는 str[i].length로 각 단어의 길이만큼 관리

### 수정전략
- 단어의 길이가 각자 달라 2차원 문자 배열로 관리를 해야겠다고 생각을 했었는데, T.solution(arr[i]) 형식 즉 반복문으로 호출하기에 매개변수로 보낸 그 당시 String 객체만 고려하면 된다.
  - 따라서 문자 배열은 1차원으로 선언해서 전달받은 String 객체의 뒤집기 작업 후 그 문자열을 return 해주는 방식으로 구현

## My Solution

```java
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
```

## Model Solution

```java
// StringBuilder의 .reverse() 이용
import java.util.*;
class Main {
  public ArrayList<String> solution(int n, String[] str){
    ArrayList<String> answer=new ArrayList<>();
    for(String x : str){
      String tmp=new StringBuilder(x).reverse().toString();
      answer.add(tmp);
    }
    return answer;
  }

  public static void main(String[] args){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int n=kb.nextInt();
    String[] str=new String[n];
    for(int i=0; i<n; i++){
      str[i]=kb.next();
    }
    for(String x : T.solution(n, str)){
      System.out.println(x);
    }
  }
}

// 직접 뒤집기
import java.util.*;
class Main {
  public ArrayList<String> solution(int n, String[] str){
    ArrayList<String> answer=new ArrayList<>();
    for(String x : str){
      char[] s=x.toCharArray();
      int lt=0, rt=x.length()-1;
      while(lt<rt){
        char tmp=s[lt];
        s[lt]=s[rt];
        s[rt]=tmp;
        lt++;
        rt--;
      }
      String tmp=String.valueOf(s);
      answer.add(tmp);
    }
    return answer;
  }

  public static void main(String[] args){
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int n=kb.nextInt();
    String[] str=new String[n];
    for(int i=0; i<n; i++){
      str[i]=kb.next();
    }
    for(String x : T.solution(n, str)){
      System.out.println(x);
    }
  }
}



```

## Refactoring

```java
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
```
1. 방법의 차이
- 나는 배열 각각의 요소를 매개변수로 받고 배열 각각의 요소를 반복해서 리턴
- 김태원 강사님은 배열 자체를 매개변수로 받고 배열 자체를 한번에 리턴
- 결론 : 각 요소별로 다른 처리가 필요한 경우에는 내 방식이 적합하나, 뒤집기 처리 로직이 전체 데이터에 공통적으로 적용되므로 강사님의 방식이 더 났다고 판단된다.

2. ArrayList의 도입
- 김태원 강사님은 String[]으로 리턴을 하지않고 ArrayList<String> 리턴 방식을 사용
- 결론 : 방법의 차이... 추후 확장성과 유연성을 고려했을때 ArrayList가 더 나을수도 있겠다고 생각된다.

3. StringBuilder의 다양한 메서드
- StringBuilder를 도입해 객체를 가변이 가능하게 만들고, .reverse()로 한번에 문자열을 뒤집을 수 있었음.
- 결론 : 가변성과 유연성을 동시에 만족하는 방식으로 이러한 메서드를 사전에 알고 있었다면 쉽게 구현할 수 있었을 것이다. 유용한 방법이므로 꼭 기억해두자

### 리팩토링 방향
- 강사님의 방식이 매우 효율적이어서 그대로 흡수를 해야겠다고 생각했다.
- 다만, 강사님의 경우 매개변수 n을 사용하지 않으셨다. 
  - 이는 ArrayList가 아닌 배열로 구현했을 경우 고정된 크기를 표현해 주어야 하기에 매개변수 n을 받아오는 것이 적합하나, ArrayList로 구현을 하고 있으므로 매개변수 n을 받아올 필요가 없다고 생각되었다. 따라서 그 부분을 제외하여 로직을 구성하였다.

## What I Learned
-  StringBuilder 클래스는 객체를 가변으로 바꿔 하나의 객체 내에서 문자열을 변경할 수 있게 해줄 뿐만 아니라, 변경할 때 유용하게 사용할 수 있는 다양한 메서드를 제공한다. 따라서 문자열을 변경해야 할 때 우선적으로 StringBuilder 클래스를 고려하자
- lt, rt로 lt > rt 까지 반복을 수행해서 문자를 직접 변경하는 기본적인 방법도 기억해두자  
- 배열 or 리스트 내의 요소들이 각각 다른 작업을 수행해야 한다면 요소를 매개변수로 받고, 공통적인 작업을 수행해야 한다면, 배열 or 리스트 자체를 매개변수로 받는 방식으로 로직을 구현하자