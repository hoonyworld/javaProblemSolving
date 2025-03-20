# Problem - 재귀함수를 이용한 이진수 출력하기 (개념잡기용)

- 해당 섹션은 개념잡기용 강의이기에 Model Solution을 빠르게 학습하고 넘어간다.

## KeyWord

- 재귀함수
- 스택프레임

## Problem Requirements

- 첫 번째 줄은 10진수 (1≤N≤1000)이 입력됨

## Problem Approach Strategy

- 스택 프레임을 활용 함수의 호출이 모두 끝난 뒤에 해당 함수가 호출되기 이전 상태로 돌아가는게 핵심

## Model Solution

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public void dfs(int n, BufferedWriter bw) throws IOException {
		if (n == 0)
			return;

		dfs(n / 2, bw);
		bw.write(n % 2 + " ");
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		T.dfs(n, bw);
		bw.flush();
		bw.close();
		br.close();
	}
}
```

## What I Learned
- 10진수를 2진수로 변환할 때는, 해당 수를 2로 나누며 나온 나머지들을 거꾸로 나열하면 2진수가 된다.
