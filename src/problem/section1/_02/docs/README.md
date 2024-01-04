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
}
```

## Refactoring

```java

```

## What I Learned