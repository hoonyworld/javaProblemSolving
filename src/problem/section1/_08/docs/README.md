# Problem - 유효한 팰린드롬

## KeyWord

- isAlphabet을 통한 알파벳 필터링
- StringBuilder의 reverse() 메서드
- StringJoiner를 통한 Character 리스트 -> 문자열 변환

## Problem Requirements

- 문자열이 팰린드롬이면 "YES", 아니면 "NO" 출력
- 단, 회문을 검사할 떄 알파벳만 가지고 회문검사, 대소문자 구분 x

## Problem Approach Strategy
### 기존전략
- 향상된 for문과 str.toLowerCase().toCharArray()를 이용
  - 문자배열을 생성하고, Character 클래스의 isAlphabetic()을 통해 알파벳만 문자배열에 저장 
- String.valueOf()로 문자 배열을 문자열로 변환하고, StringBuilder 객체를 생성하여 reverse()를 이용해 비교
  - if(lowerStr.equals(reverseStrBuilder.toString())과 같은 형식 사용
    - 만족하면 YES, 아니면 NO 출력
### 수정전략
- 문자 배열을 생성할 경우 크기를 지정해 줘야 하는데, 알파벳만 있는 문자열의 길이를 알지 못하기 때문에 ArrayListㄹ를 이용하는 방향으로 변환
- String.valueOf()로 리스트를 문자열로 변환하면 리스트 형태 그대로 문자열로 반영되었음. (ex. [h, e, l, l, o])
  - 그래서 StringJoiner를 사용해 문자열로 변환하는 방법을 사용하였음.
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