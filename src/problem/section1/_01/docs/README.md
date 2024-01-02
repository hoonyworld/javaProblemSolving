# Problem - 문자 찾기

## KeyWord

- 문자열 → 문자

## Problem Requirements

- 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램
- 대소문자 구분 X
- 문자열의 길이는 100을 넘지 X

## Problem Approach Strategy

- 개수를 세는 int 자료형 변수 count를 생성하고 0으로 초기화 
- 입력받은 문자열을 char 배열에 문자 하나씩 저장 - charAt 이용
- 특정 문자를 입력받을 때 소문자로 변환하여 저장 - .next().toLowerCase() 이용
- 그 후 입력받은 문자(String 자료형)를 .charAt(0)로 새로운 char 자료형 변수에 저장
  - 여기서 대문자 문자를 저장하는 변수 하나를 추가로 생성하고 .toUpperCase()로 대문자로 변환하여 저장 - 즉, 소문자 변수 1개, 대문자 변수 1개 총 2개
- for문으로 배열 순회
  - 두번째 입력받은 문자를 char 배열 0번째 index ~ 마지막 index까지 순회
    - if (arr[i] == 소문자 || arr[i] == 대문자) 형식으로 대소문자 체크
    - if문이 true이면 count++ 로 개수 체크

## My Solution

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String generalString = sc.next();
        String strLowerCase = sc.next().toLowerCase();

        char[] arr = new char[generalString.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generalString.charAt(i);
        }
        char criteriaLowerCase = strLowerCase.charAt(0);
        char criteriaUpperCase = strLowerCase.toUpperCase().charAt(0);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == criteriaLowerCase || arr[i] == criteriaUpperCase) {
                count++;
            }
        }
        System.out.println(count);
    }
}
```

## Model Solution

```java
import java.util.*;
class Main{
    public int solution(String str, char t){
        int answer=0;
        str=str.toUpperCase();
        t=Character.toUpperCase(t);
		/* for(int i=0; i<str.length(); i++){
			if(str.charAt(i)==t) answer++;
		} */
        for(char x : str.toCharArray()){
            if(x==t) answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        char c=kb.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}
```

## Refactoring

```java
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
```
1. 문자 찾기 방식
- 본인은 문자를 소문자와 대문자로 변환하여 (소문자 일치 || 대문자 일치) 방식 
- 김태원 강사님은 문자열과 문자를 모두 대문자로 변환하여 체크하는 방식 
- 결론 : 더 간단하고, 실전에서 바로 떠오를 수 있는 강사님의 방식을 우선적으로 선택하자

2. 배열 vs 배열 X
- 본인은 배열을 이용해 문자열을 문자로 하나씩 분리해 저장하는 방식 
- 김태원 강사님은 배열을 사용하지 X 방식
- 결론 : 불필요한 배열이다

3. Character.toUpperCase/toLowerCase(변수)
- 본인은 문자를 String 자료형으로 저장해 대/소문자로 변환하고 .charAt(0)으로 다시 char 자료형을 가져오는 방식 
- 김태원 강사님은 Character.toUpperCase(변수)/toLowerCase(변수)로 문자를 대/소문자로 변환 하여 char 자료형에 바로 저장하는 방식
- 결론 : Character 클래스에 대/소문자로 바꿔주는 메서드의 존재를 몰랐기에 해당 방식으로 구현하였다. 따라서 김태원 강사님이 알려주신 방법을 앞으로 이용하자


## What I Learned
- 무조건 배열이나 리스트를 만들려고 하지 않기
- Character.toUpperCase(char 자료형 변수)/toLowerCase(char 자료형 변수) → "문자"를 대/소문자로 변환
- (String 자료형 변수).toCharArray() → "문자열"을 새로운 "문자 배열"로 변환
    ``` java
    String str = "Hello";
    char[] chars = str.toCharArray();
    ```
-  향상된 for문을 사용할 때에는 배열 or 리스트를 참조해서 가져와야 함. 따라서 str.toCharArray() 를 써주어서 문자배열로 바꿔준 것.