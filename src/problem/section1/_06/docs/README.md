# Problem - 중복문자제거

## KeyWord

- 중복 요소를 어떻게 제거할 것 인가?
- LinkedHashSet (들어온 순서 보장)

## Problem Requirements

- 소문자로 작성된 문자열 중복된 문자 제거 후 출력
- 단, 중복제거된 문자열의 각 문자는 원래 문자열 순서 유지

## Problem Approach Strategy

### 기존전략
- toCharArray()를 사용해서 문자배열을 만든 후, Character 리스트에 추가
- 버블정렬을 응용하여 동일한 문자를 만날경우 remove 메서드로 제거

### 고민
- 버블정렬을 응용하여 다음과 같은 코드를 짜보았다. 

``` java
List<Character> alphabet = new ArrayList<>();
char[] ch = str.toCharArray();
String answer = "";

for (int i = 0; i < ch.length; i++) {
    alphabet.add(ch[i]);
}

// aabbc
int arrayLength = ch.length;
for (int i = arrayLength - 1; i > 0; i--) {
    for (int j = i - 1; j >= 0; j--) {
        if (alphabet.get(i) == alphabet.get(j)) {
            alphabet.remove(i);
        }
    }
}

for (int i = 0; i < alphabet.size(); i++) {
    answer += alphabet.get(i);
}
return answer;
```
- 뒤에서 부터 탐색을 시작하여 일치할 경우 현재 인덱스 i의 값을 지우는 방식으루 구현하였다.
- 하지만 리스트의 크기가 변화가 생겨 예상치 못한 결과가 일어났다(Out of Index, 동일한 인덱스 비교)
- 그래서 중복 제거를 해주는 Set을 이용해서 구현을 해야겠다는 생각을 하게되었다.

### 수정전략
- 그냥 Set은 순서를 보장해 주지 않는다.
    - 따라서 들어온 순서를 보장해주는 LinkedHashSet을 사용하여 구현하자

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