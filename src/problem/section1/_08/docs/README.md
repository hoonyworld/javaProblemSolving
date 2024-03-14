# Problem - 유효한 팰린드롬

## KeyWord
- isAlphabet을 통한 알파벳 필터링
- StringBuilder의 reverse() 메서드
- StringJoiner를 통한 Character 리스트 -> 문자열 변환
- replaceAll({정규식}, "문자열)

## Problem Requirements

- 문자열이 팰린드롬이면 "YES", 아니면 "NO" 출력
- 단, 회문을 검사할 때 알파벳만 가지고 회문검사, 대소문자 구분 x

## Problem Approach Strategy
### 기존전략
- 향상된 for문과 str.toLowerCase().toCharArray()를 이용
  - 문자배열을 생성하고, Character 클래스의 isAlphabetic()을 통해 알파벳만 문자배열에 저장 
- String.valueOf()로 문자 배열을 문자열로 변환하고, StringBuilder 객체를 생성하여 reverse()를 이용해 비교
  - if(lowerStr.equals(reverseStrBuilder.toString())과 같은 형식 사용
    - 만족하면 YES, 아니면 NO 출력
    
### 수정전략
- 문자 배열을 생성할 경우 크기를 지정해 줘야 하는데, 알파벳만 있는 문자열의 길이를 알지 못하기 때문에 ArrayList를 이용하는 방향으로 변환
- String.valueOf()로 리스트를 문자열로 변환하면 리스트 형태 그대로 문자열로 반영되었음. (ex. [h, e, l, l, o])
  - 그래서 StringJoiner를 사용해 문자열로 변환하는 방법을 사용하였음.
  
## My Solution

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

class Main {
    public String solution(String str) {
        List<Character> onlyAlphabet = new ArrayList<>();
        for (char x : str.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(x)) {
                onlyAlphabet.add(x);
            }
        }

        StringJoiner sj = new StringJoiner("");
        for (Character c : onlyAlphabet) {
            sj.add(String.valueOf(c));
        }

        String s = sj.toString();
        StringBuilder sb = new StringBuilder(s);

        if (s.equals(sb.reverse().toString())) {
            return "YES";
        } else
            return "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String palindrome = kb.nextLine();
        System.out.println(T.solution(palindrome));
    }
}
```

## Model Solution

```java
import java.util.*;
class Main {	
	public String solution(String s){
		String answer="NO";
		s=s.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp=new StringBuilder(s).reverse().toString();
		if(s.equals(tmp)) answer="YES";
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
    String answer = "NO";
    str = str.toLowerCase().replaceAll("[^a-z]", "");
    String reverseSentence = new StringBuilder(str).reverse().toString();

    if (str.equals(reverseSentence)){
      return "YES";
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    String palindrome = kb.nextLine();
    System.out.println(T.solution(palindrome));
  }
}
```
1. replaceAll()
- 결론 : replaceAll()이 내가 한 작업(알파벳만 분리, 합치기)을 더 간단하게 하는 방법인 것 같다. 물론 정규식의 경우 백트래킹으로 일치여부를 판단하므로 최악의 경우 O(2^n)의 시간복잡도를 가질 수 있다. 따라서 시간복잡도를 주의해야 하는 문제의 경우에는 내가 한 방법으로 설계해보자

2. else
- 결론 : 1-7 문제에서 말했듯이, else 사용을 최대한 지양하고 값을 리턴해주는 방식으로 설계하자

### 리팩토링 방향
- 강사님의 방식이 매우 유용한 방식인 것 같다. 그대로 체득하자.

## What I Learned
- 문자열의 특정문자를 없애거나, 치환할 때 replaceAll()가 유용하게 사용될 것 같다.
- 간단한 정규식은 알아두자