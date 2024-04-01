# Problem - 숫자만 추출

## KeyWord

- Character 클래스의 isDigit()

## Problem Requirements

- 숫자와 문자가 섞여있는 문자열에서 숫자만 추출해서 그 순서대로 문자열 만들기
- 앞에 0이 있으면 0은 빼고 만들기

## Problem Approach Strategy
### 기존전략
- Integer 자료형을 저장하는 ArrayList를 생성한다.
- for문 순회
  - if (Character.isDigit(str.charAt(i))) 이면, 리스트에 add
- int index = 0 선언
  - for문 순회
    - if (list.get(i) != 0) { index = i; break;} 
      - 첫번째로 0이 아닌 숫자가 걸릴 때 index 값을 저장하고 break;
- for문 순회
  - i < index 까지 0이 있으면 remove()로 지움

### 수정전략
- Integer 리스트에 저장하니, str.charAt(i)를 add 하는데 형변환에 어려움이 있었음.
  - char로 리턴하기 때문에 (int)로 형변환을 해준다고 해도 ASCII의 10진수로 변환되어 저장됨.
  - 따라서 Character 리스트로 만들고, answer에 누적해서 String으로 리턴하는 방식 채택.
- 리스트 원소를 순회하며 처음으로 0이 아닌 숫자가 등장하는 index를 찾고, 그 index전까지 for문으로 0을 remove() 해주려 했으나, 원소의 index가 변하면서, 문제 발생
  - 따라서 while 문으로 list.get(0) == '0' 조건 하에서 0을 remove 해주는 로직을 도입해, index 문제 해결 

## My Solution

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public String solution(String str) {
        String answer = "";
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                list.add(str.charAt(i));
            }
        }
        
        while (list.get(0) == '0') {
            list.remove(0);
        }

        for (int i = 0; i < list.size(); i++) {
            answer += String.valueOf(list.get(i));
        }

        return answer;
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
	public int solution(String s){
		//int answer=0;
		String answer="";
		for(char x : s.toCharArray()){
			//if(x>=48 && x<=57) answer=answer*10+(x-48);
			/*if(Character.isDigit(x)){
				answer=answer*10+ Character.getNumericValue(x);
			}*/
			if(Character.isDigit(x)) answer+=x;
		}
		return Integer.parseInt(answer);
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

```
1. ASCII vs Character 클래스의 isDigit
- 강사님의 ASCII 코드를 사용한 방식은 식을 생각해 내기가 쉽지 않을 것 같다. 
- 결론 : 따라서 Character.isDigit()으로 앞으로 숫자 여부를 판단하자

2. 코드의 간결화
- 나는 숫자만 따로 Arraylist로 추출하고, 앞에 있는 의미없는 0을 리스트에서 제거하고, 다시 리스트 요소를 하나하나 String.valueOf()로 합쳤다. 
- 강사님은 숫자만 answer에 저장하고, Integer.parseInt()로 앞에 있는 의미없는 0을 제거해주었다.
- 결론 : 간결한 코드가 최고다. 강사님의 방식을 이용하자

### 리팩토링 방향
1. 강사님의 방식을 이용하여 불필요한 리스트를 제거해 보다 간결한 코드를 만들자.

## What I Learned
- Character 클래스의 isDigit()은 매개변수 x(문자형)이 숫자이면 true를 반환한다.
- 48~57 사이의 10진수는 순서대로 문자 '0'~'9'를 나타낸다.