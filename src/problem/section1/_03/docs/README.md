# Problem - 문장 속 단어

## KeyWord
- 인덱스 위치 저장

## Problem Requirements
- 한 개의 문장이 입력되면, 그 문장에서 가장 긴 단어를 찾아 출력
- 만약 가장 긴 단어가 여러개이면 가장 앞쪽에 위치한 단어를 출력
- 단어는 공백으로 구분되며 모두 알파벳으로만 구성



## Problem Approach Strategy
### 기존전략
- str.charAt(i) = ' ' 으로 공백을 체크하여, str.substring(바로 전의 공백 index + 1, 현재 공백 index)으로 문자열(단어) 추출
- 문자열 추출시 .length()로 길이를 추출해서 현재 가장 긴 문자열(단어)의 길이가 저장되어 있는 변수와 길이 비교 후 더 클 경우 change.
- 또한 가장 긴 문자열의 시작 index를 저장해서 최종적으로 출력할때, substring(i, i + length) 만큼 출력

### 수정전략
- 가장 긴 문자열(단어)가 마지막에 있는 경우 공백 체크가 불가능 하였음. (마찬가지로 개행 체크도 불가능).
  - 따라서 기존 문자열 마지막에 공백(" ")을 붙여 새로운 String 객체를 생성해 이를 이용하였음.
- 처음에 index를 move라는 변수 하나로만 체크했으나, 가장 길이가 긴 문자열의 시작 index를 저장하지 못하게 되는 상황이 발생함
  - 따라서 first라는 정수형 변수 한개를 추가로 생성해, 가장 길이가 긴 문자열의 시작 index를 저장하도록 설계하였음.

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