# Problem - 대소문자 변환

## KeyWord

- 소문자 ↔ 대문자

## Problem Requirements

- 대문자와 소문자가 같이 존재하는 문자열을 입력받은 후 대문자 → 소문자, 소문자 → 대문자로 변환
- 문자열은 영어 알파벳으로만 구성, 문자열의 길이는 100을 넘지 않음

## Problem Approach Strategy

- 입력 받은 문자열을 모두 소문자/대문자로 변환하여 각각 새로운 String 자료형에 저장
- for문 순회
  - if (기존 문자열.charAt(i) == 새로운 문자열(소문자).charAt(i)) → 일치하면 대문자로 변환
  - else if (기존 문자열.charAt(i) == 새로운 문자열(대문자).charAt(i)) → 일치하면 소문자로 변환

## My Solution

```java
import java.util.Scanner;

class Main {
    public String solution(String str) {
        StringBuilder convertString = new StringBuilder(str);
        String upperCaseString = str.toUpperCase();
        String lowerCaseString = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == upperCaseString.charAt(i)) {
                convertString.setCharAt(i, str.toLowerCase().charAt(i));
            } else if (str.charAt(i) == lowerCaseString.charAt(i)) {
                convertString.setCharAt(i, str.toUpperCase().charAt(i));
            }
        }
        return convertString.toString();
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
```

## Model Solution

```java
import java.util.*;

class Main {
    public String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x))
                answer += Character.toUpperCase(x);
            else
                answer += Character.toLowerCase(x);
        }
        
        /*for(char x : str.toCharArray()){
			if(x>=97 && x<=122) answer+=(char)(x-32);
			else answer+=(char)(x+32);
		}*/
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }  
}
```

## Refactoring

```java
import java.util.Scanner;

class Main {
    public String solution(String str) {
        StringBuilder convertString = new StringBuilder(str);

        for (int i = 0; i < convertString.length(); i++) {
            char ch = convertString.charAt(i);
            if (Character.isLowerCase(ch)) {
                convertString.setCharAt(i, Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                convertString.setCharAt(i, Character.toLowerCase(ch));
            }
        }

        return convertString.toString();
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}

```
1. 대소문자 변환 방식
- 본인은 자바에서 String의 불변성(immutable)을 고려하여 가변성(mutable)인 StringBuilder를 도입하였고, StringBuilder 객체를 직접 수정하는 방식
- 김태원 강사님은 빈 문자열을 시작으로 각 문자를 확인하면서 대소문자를 변경한 후, 그 결과를 누적하는 방식
- 결론 : 가독성 및 코드의 단순성 측면에서는 강사님의 코드가 더 났다고 생각한다. 그러나 answer에 문자열을 계속 할당할 때마다 새로운 String 객체가 생성되고, 기존객체는 버려진다. 이렇게 되면 입력 예시(StuDY)와 같이 길이가 작은 문자열에 대해서는 성능 차이가 거의 없으나, 길이가 긴 문자열에 대해서는 성능 저하를 발생시킬 수 있다고 판단된다. 따라서 시간복잡도를 고려해야 하는 상황이라면 후자의 방법을 선택하자.

2. 추가 문자열 생성 vs 추가 문자열 생성 X
- 본인은 대문자로만 구성된 새로운 String 객체 1개, 소문자로만 구성된 새로운 String 객체 1개 총 2개를 생성한 후. 현재 문자가 원본 str에서 대문자인지 소문자인지를 판단하는 방식
- 김태원 강사님은 Character 클래스의 isLowerCase/isUpperCase 메서드를 이용해서 각 문자가 소문자인지 대문자인지를 직접 확인하는 방식
- 결론 : 김태원 강사님 방식이 훨씬 효율적이다. 내 방식은 문자열의 길이가 길어질 수록 메모리 사용량이 증가하기에 비효율적이다. 또한 각 문자의 상태를 직접 확인하기에 더 직관적인 것 같다. 따라서 강사님의 방식을 선택하자. 

## What I Learned
- if (str.charAt(i) == str.toUpperCase().charAt(i)) { str.charAt(i) = str.toLowerCase().charAt(i) } 방식으로 처음 코드를 적었으나, String 객체는 immutable 하기에 오류가 발생했었다. 그래서 String 객체 자체를 변경하고 싶다면, StringBuilder나 StringBuffer를 고려해보자.
- ASCII 코드에서 대문자는 65~90이고 소문자는 +32를 해주면 된다. 유용하게 사용할 수 있으니 일단 외워두자.
- 문자와 숫자 간의 연산이 일어날 때, 각 문자의 해당하는 ASCII 코드의 정수 값이 사용되고, 정수형태로 바뀌어 저장되게 된다. 따라서 연산 결과를 문자로 출력하고 싶으면 (char)를 붙여 형 변환을 해주자.
- Character 클래스의 isUpper/LowerCase, toUpper/LowerCase가 문자를 다룰 때 .charAt(i)로 문자를 빼오는 것보다 훨씬 유용한 것 같으므로 역시 외우자.