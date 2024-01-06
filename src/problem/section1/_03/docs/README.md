# Problem - 문장 속 단어

## KeyWord

- 인덱스 위치 저장

## Problem Requirements

- 한 개의 문장이 입력되면, 그 문장에서 가장 긴 단어를 찾아 출력
- 만약 가장 긴 단어가 여러개이면 가장 앞쪽에 위치한 단어를 출력
- 단어는 공백으로 구분되며 모두 알파벳으로만 구성

## Problem Approach Strategy

- str.charAt(i) = ' ' 으로 공백을 체크하여, str.substring(바로 전의 공백 index + 1, 현재 공백 index)으로 문자열(단어) 추출
- 문자열 추출시 .length()로 길이를 추출해서 현재 가장 긴 문자열(단어)의 길이가 저장되어 있는 변수와 길이 비교 후 더 클 경우 change.
- 또한 가장 긴 문자열의 시작 index를 저장해서 최종적으로 출력할때, substring(i, i + length) 만큼 출력

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