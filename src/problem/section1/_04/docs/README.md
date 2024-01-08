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

```

## Model Solution

```java

```

## Refactoring

```java

```

## What I Learned

-