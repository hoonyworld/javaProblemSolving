# Problem - 특정 문자 뒤집기

## KeyWord
- 알파벳 판별(Character 클래스의 isAlphabetic()) 
- 왼쪽(lt)과 오른쪽(rt) 포인터 개별 관리 

## Problem Requirements
- 알파벳 + 특수문자로 구성된 문자열에서 알파벳만 뒤집고 특수문자는 그 본래 위치에 유지하는 문자열 출력

## Problem Approach Strategy
### 기존전략
- 정규표현식 사용 (if문으로)
  - 알파벳인 경우에만 &rightarrow; 뒤집기 진행
- 뒤집기 진행 방식 (while문으로)
  - 문자열을 문자배열로 만들고 첫번째 index를 lt, 마지막 index를 rt로 설정하여 lt >= rt 이면 멈출 때까지(ex. while(lt < rt)) 반목문 수행
  - 한번 사이클이 돌때마다 lt++, rt--를 해줌.
### 수정전략
- a#b!GE*T@S의 예를 보고 lt와 rt가 모두 알파벳인 경우에만 스왑을 해주고, 나머지 경우(lt 알파벳/rt 특수문자,lt 특수문자/rt 알파벳, lt 특수문자/rt 특수문자)에는 스왑을 해주지 않는 방향으로 전략을 구성하였었음. 
- 하지만 kdj#@kdjg%$#kdjgk@kd$dk 경우를 보았을 때, lt인 arr[3] = 'j', rt인 arr[21] = & 인 경우 arr[3]은 arr[20] = 'd'와 스왑을 해주어야 한다는 사실을 알게됨. 즉, 특수문자가 같이 있는 문자열의 경우 lt와 rt를 같이 관리하면 안됨.
- 특수문자를 제외한 문자열을 생성하여, 기존 lt와 rt 전략으로 스왑을 해주고, StringBuilder의 insert 메서드로 스왑된 문자열에 기존 index 위치에 특수문자들을 삽입시켜 주는 방향으로 전략 수정.
  
## My Solution

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder(str);
        List<Integer> nonAlphabetIndex = new ArrayList<>();
        List<Character> nonAlphabet = new ArrayList<>();

        String regex = "^[a-zA-Z]$";
        for (int i = 0; i < sb.length(); i++) {
            if(!Character.toString(sb.charAt(i)).matches(regex)) {
                nonAlphabetIndex.add(i);
                nonAlphabet.add(sb.charAt(i));
            }
        }

        for (int i = nonAlphabetIndex.size()-1; i >= 0; i--) {
            sb.deleteCharAt(nonAlphabetIndex.get(i));
        }
        
        
        int lt = 0;
        int rt = sb.length() - 1;
        while (lt < rt) {
            char temp = sb.charAt(lt);
            sb.setCharAt(lt, sb.charAt(rt));
            sb.setCharAt(rt, temp);
            lt++;
            rt--;
        } // sb.reverse()로 구현하면 이 8줄의 코드를 1줄로 줄일 수 있다. (현재 특수문자가 빠진 문자열이기에 사용 가능)
        
       for (int i = 0; i < nonAlphabetIndex.size(); i++) {
            sb.insert(nonAlphabetIndex.get(i), nonAlphabet.get(i).toString());
        }

        return sb.toString();
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
	public String solution(String str){
		String answer;
		char[] s=str.toCharArray();
		int lt=0, rt=str.length()-1;
		while(lt<rt){
			if(!Character.isAlphabetic(s[lt])) lt++;
			else if(!Character.isAlphabetic(s[rt])) rt--;
			else{
				char tmp=s[lt];
				s[lt]=s[rt];
				s[rt]=tmp;
				lt++;
				rt--;
			}
		}
		answer=String.valueOf(s);
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}
```

## Refactoring

```java
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
```
1. 발상의 차이
- 나는 위에서 말했듯이 lt++, rt--를 동시에 하여 스왑을 하는 방식을 채택했지만, 같이 관리함으로서 발생하는 문제점을 발견하였고 때문에 특수문자를 제외하여 스왑하고 나중에 원래 위치로 insert 하는 방법이 먼저 생각남.
- 김태원 강사님은 lt와 rt를 각각 따로 관리함으로서 간단하고 명료하게 해당 문제의 솔루션을 구현하였음.
- 결론 : 강사님 방식이 외우고 싶고 더 간단한 것 같다.비록 이 방식을 떠올리지 못했지만, 좋은 방식이기에 코드를 여러 번 적으며 체화하자.

2. Character 클래스의 isAlphabetic 메서드
- 결론 : 유용한 메서드인 것 같다. 해당 메서드를 모르고 있어 정규식으로 알파벳을 골라내는 방법을 사용했는데, 다음부터는 동일한 상황이 나오면 이 메서드를 우선적으로 도입 해봐야 겠다.

3. StringBuilder vs char[]
- 나는 문자열을 변경하는 경우 StringBuilder를 우선적으로 도입하자고 생각하고 있었어서 이번에도 StringBuilder를 도입하였음. 
- 김태원 강사님은 toCharArray로 문자열을 문자배열을 바꾸는 방법을 도입하였음.
- 결론 : 문자열을 변경할 때 경우에 따라 문자배열로 구현하는 방향도 좋은 선택지가 될 수도 있겠다고 생각이 들었다. 

### 리팩토링 방향
- 강사님의 방식을 StringBuilder로 구현해보았다. 
  - StringBuilder가 더 괜찮아서 사용한 것이 아니다. 이번에는 "특수문자는 변경 x" 조건이 붙어 StringBuilder 클래스의 .reverse()를 사용하지 못했기에 StringBuilder나 char[]이나 큰 차이는 없다고 생각된다. 
  - 따라서 강사님의 코드를 익힐 겸, "StringBuilder로 바꿔보자"는 생각으로 리팩토링을 진행하였다.
  
## What I Learned
- 문자가 알파벳인지 아닌지를 체크해야 하는 경우 Character 클래스의 isAlphabetic을 사용하자. 정규식과 매칭해보는 과정보다 편리하다.
- 문자열을 변경하는 경우 StringBuilder 클래스 뿐만 아니라 toCharArray()를 통한 char[]도 좋은 선택지가 될 수 있다.
- 내가 강사님의 방식을 떠올리지 못했지만, 다양한 시도를 해봄으로서 이 문제를 풀 수 있었다. 그 시도속에서 StringBuilder의 insert, deleteCharAt 메서드를 알 수 있었다. 유용한 메서드 였으므로 기억해두자.