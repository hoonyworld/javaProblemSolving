# Problem - 특정 문자 뒤집기

## KeyWord
- 정규표현식

## Problem Requirements
- 알파벳 + 특수문자로 구성된 문자열에서 알파벳만 뒤집고 특수문자는 그 본래 위치에 유지하는 문자열 출력

## Problem Approach Strategy
### 기존전략
- 정규표현식 사용 (if문으로)
  - 알파벳인 경우에만 &rightarrow; 뒤집기 진행
- 뒤집기 진행 방식 (while문으로)
  - 문자열을 문자배열로 만들고 첫번째 index를 lt, 마지막 index를 rt로 설정하여 lt >= rt 이면 멈출 때까지(ex while(lt < rt)) 반목문 수행
  - 한번 사이클이 돌때마다 lt++, rt--를 해줌.
### 수정전략
- a#b!GE*T@S의 예를 보고 lt와 rt가 모두 알파벳인 경우에만 스왑을 해주고, 나머지 경우(lt 알파벳/rt 특수문자,lt 특수문자/rt 알파벳, lt 특수문자/rt 특수문자)에는 스왑을 해주지 않는 방향으로 전략을 구성하였었음. 
- 하지만 kdj#@kdjg%$#kdjgk@kd$dk 경우를 보았을 때, lt인 arr[3] = 'j', rt인 arr[21] = & 인 경우 arr[3]은 arr[20] = 'd'와 스왑을 해주어야 한다는 사실을 알게됨.
- 특수문자를 제외한 문자열을 생성하여, 기존 lt와 rt 전략으로 스왑을 해주고, StringBuilder의 insert 메서드로 스왑된 문자열에 기존 index 위치에 특수문자들을 삽입시켜 주는 방향으로 전략 수정
  
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