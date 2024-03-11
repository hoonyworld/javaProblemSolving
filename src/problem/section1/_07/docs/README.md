# Problem - 회문 문자열

## KeyWord

- StringBuilder의 reverse() 메서드
- ==, equals() 의 정확한 개념

## Problem Requirements

- 회문문자열이 입력되면 YES, 아니면 NO 출력
- 단, 대소문자 구분 x

## Problem Approach Strategy

- 입력받은 문자열을 모두 LowerCase로 변형
- StringBuilder의 reverse() 메서드를 사용해 비교
  - LowerCase 문자열과 그 문자열에 reverse()를 한 문자열이 같으면 YES, 아니면 NO 출력.

### 고민
- if (reverseStrBuilder.reverse().toString().equals(reverseStrBuilder.toString())) 
  - 해당 방법의 경우 reverse() 메서드가 한번 호출되면, reverse 된 상태로 sb 객체가 유지되게 된다. 
  - 따라서 reverse() 된 문자열끼리 비교하는 것이기 떄문에 동일한 문자열이므로 항상 true가 된다.
- if (reverseStrBuilder.reverse().toString() == reverseStrBuilder.toString())
  - 해당 방법의 경우 toString이 호출될 때 서로 다른 String 객체를 만들어 낸다. '=='는 같은 객체를 참조하고 있는 지 여부를 판단하는 연산자 이므로 항상 false가 된다.
  
## My Solution

```java
import java.util.Scanner;

class Main {
    public String solution(String str) {
        String lowerStr = str.toLowerCase();
        StringBuilder reverseStrBuilder = new StringBuilder(lowerStr).reverse();

        if (lowerStr.equals(reverseStrBuilder.toString())) {
            return "YES";
        } else
            return "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String palindrome = kb.next();
        System.out.println(T.solution(palindrome));
    }
}
```

## Model Solution

```java
// 자료구조 이용 x, 양쪽의 문자를 비교
import java.util.*;
class Main {	
	public String solution(String str){
		String answer="YES";
		str=str.toUpperCase();
		int len=str.length();
		for(int i=0; i<len/2; i++){
			if(str.charAt(i)!=str.charAt(len-i-1)) answer="NO";
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}


// 자료구조 이용, reverse 메서드
import java.util.*;
class Main {	
	public String solution(String str){
		String answer="NO";
		String tmp=new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(tmp)) answer="YES";
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
        String answer = "NO";
        StringBuilder reverseStrBuilder = new StringBuilder(str).reverse();

        if (str.equalsIgnoreCase(reverseStrBuilder.toString())) {
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String palindrome = kb.next();
        System.out.println(T.solution(palindrome));
    }
}
```
1. 리턴 방식
- 나는 if-else 문을 이용해 if문과 성립하면 YES, 틀리면 NO를 리턴하도록 구성하였다. 
- 강사님은 answer에 NO를 할당하고, if문의 조건에 성립하는 경우에만 true를 리턴하고, 아닐경우 그대로 answer를 리턴하는 방식으로 구성하였다.
- 결론 : 강사님의 방식이 적합하다. 클린코드에서 배웠듯이 else의 사용을 지향하는 방법을 사용하셨다. 변수에 값을 할당하고 if문과 일치하지 않으면 그대로 return 하는 방식을 채택하자.

2. equalsIgnoreCase()
- 결론 : 대소문자를 구분하지 않고, 동등성을 확인해준다. 따라서 대소문자 관련없이 비교해야 할경우 해당 메서드를 사용하자.

### 리팩토링 방향
- answer에 NO를 할당하고, if문과 일치할 경우 YES 리턴, 일치하지 않으면 그대로 answer 값을 리턴하도록 리팩토링
- equalIgnoreCase()를 사용해, toLowerCase()로 소문자로 만드는 부분 삭제

## What I Learned
- 대소문자를 구분하지 않는 상태해서 동등성을 비교해야 할 때, equalsIgnoreCase()를 사용하자.
- else의 사용을 지양하기 위해, if문과 일치하는 경우가 아니면 저장한 값 그대로 값을 리턴하는 방식을 사용하자.