# Problem - 메모이제이션을 이용한 피보나치 (개념잡기용)

- 해당 섹션은 개념잡기용 강의이기에 Model Solution을 빠르게 학습하고 넘어간다.

## KeyWord

- 재귀함수
- 스택프레임

## Problem Requirements

- 첫 번째 줄에 총 항수 (3≤N≤45)이 입력됨

## Problem Approach Strategy

- 메모이제이션을 활용하면, 배열에 각 dfs 호출의 결과를 저장해두고 이미 저장된 값이 있으면 바로 반환하도록 하여 연산 시간을 줄일 수 있다.  

## Model Solution

```java
package problem.section7._04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  // solution 1
  public int dfs(int n) {
  	if (n == 1)
  		return 1;
  	else if (n == 2)
  		return 1;
  	else
  		return dfs(n - 1) + dfs(n - 2);
  }

  public static void main(String[] args) throws IOException {
  	Main T = new Main();
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  	int n = Integer.parseInt(br.readLine());

  	for (int i = 1; i <= n; i++) {
  		bw.write((T.dfs(i) + " "));
  	}

  	bw.flush();
  	bw.close();
  	br.close();
  }

  // solution 2
  static int[] fibo;

  public int dfs(int n) {
  	if (n == 1)
  		return fibo[n] = 1;
  	else if (n == 2)
  		return fibo[n] = 1;
  	else
  		return fibo[n] = dfs(n - 1) + dfs(n - 2);
  }

  public static void main(String[] args) throws IOException {
  	Main T = new Main();
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  	int n = Integer.parseInt(br.readLine());
  	fibo = new int[n + 1];
  	T.dfs(n);

  	for (int i = 1; i <= n; i++) {
  		bw.write((fibo[i] + " "));
  	}

  	bw.flush();
  	bw.close();
  	br.close();
  }

  // solution 3
  static int[] fibo;

  public int dfs(int n) {
    if (fibo[n] > 0)
      return fibo[n];

    if (n == 1)
      return fibo[n] = 1;
    else if (n == 2)
      return fibo[n] = 1;
    else
      return fibo[n] = dfs(n - 1) + dfs(n - 2);
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    fibo = new int[n + 1];
    T.dfs(n);

    for (int i = 1; i <= n; i++) {
      bw.write((fibo[i] + " "));
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
```

## What I Learned

### solution 1
- 재귀 호출만을 사용하여 피보나치 수열을 계산하는 방식
- 중복 호출이 심각하게 발생 (예: dfs(5) → dfs(4), dfs(3)가 여러 번 호출), 시간 복잡도: O(2^n) → 비효율적, 큰 수 입력 시 StackOverflowError 발생 가능

### solution 2
- fibo[] 배열을 통해 계산 결과를 저장하는 메모이제이션 기법 사용하는 방식
- 이전에 계산한 값이 있어도 dfs()를 반복 호출하므로, Solution 1보다 약간 개선된 정도, 중복 계산을 막지 못해 여전히 시간 복잡도 O(2^n)

### solution 3
- fibo[n] 값이 존재하는지 먼저 확인 → 이미 계산한 값이면 즉시 반환하는 방식
- 중복 호출 제거로 시간 복잡도: O(n) → 매우 효율적, 큰 수 입력 시에도 StackOverflowError 위험이 사라짐
