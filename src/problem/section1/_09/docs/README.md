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

## My Solution

```java

```

## Model Solution

```java

```

## Refactoring

```java

```

### 리팩토링 방향

## What I Learned

-