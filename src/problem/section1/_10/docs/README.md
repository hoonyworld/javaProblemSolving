# Problem - 가장 짧은 문자거리

## KeyWord

- indexOf, lastIndexOf
- 케이스 분류(평균)

## Problem Requirements

- 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력

## Problem Approach Strategy

- int distance = 0;
- int[] arr = new int[str.length()];
- for문 순회(0 ~ str.length()-1 까지)
  - if(str.chaAt(i) == c)일때 인덱스 i를 Integer 타입의 ArrayList에 add
- 평균 배열(double)을 만든 후 인접한 인덱스 끼리 평균 계산해서 저장하기 (ex i = 2, i = 5 → avg는 3.5)

- 각 인덱스 별 평균 사이의 값들에 대해서 위치 판단
- for문 순회(0 ~ avg.length-1 까지)
  - for문 순회1(int j = indexOfStandard.get(i); j <= (int)avg[i]; j++))
    - arr[i] = distance(현재는 0) 후 distance++를 해주며 거리 증가
      - ex) 1 ~ (int)3.5 까지 -> 1 ~ 3 까지 arr[i] = distance;
  - for문 순회2(int j = (int)avg[i] + 1; j < indexOfStandard.get(i+1); j++)
    - if(평균이 정수이면) -> distance를 1 감소 후, arr[j] = distance;
    - else(즉 평균이 정수가 x) -> arr[j] = distance 후, distance 1 감소
- 처음 등장한 문자 전 까지 거리 처리
  - i = str.indexOf(c) ~ 0 까지 arr[i] = distance 후, distance 1 증가 
- 마지막 등장한 문자 후의 거리 처리
  - i = str.lastIndexOf(c) ~ str.length()-1 까지 arr[i] = distance 후, distance 1 증가

### 문제상황 및 해결방법
```
for (int i = 0; i < avg.length; i++) {
    // for문 1
    for (int j = indexOfStandard.get(i); j <= (int)avg[i]; j++) {
        arr[j] = distance;
        distance++;
    }

    distance--; // 추가!
    // for문 2
    for (int j = (int)avg[i] + 1; j < indexOfStandard.get(i+1); j++) {
        if (avg[i] % 1 == 0.0) {
            distance--;
            arr[j] = distance;
        } else {
            arr[j] = distance;
            distance--;
        }
    }
    
    distance = 0;
}
```
- for문 1이 끝나고 다음 for문 2로 넘어갈 때 distance가 1씩 증가하는 상황이 발생해, 원래 출력되어야 하는 거리 +1 이 되게되었다.
- 따라서 distance--;를 추가하여 마지막에 증감된 distance를 1 감소해줘서 변화가 없게 만들었다.


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