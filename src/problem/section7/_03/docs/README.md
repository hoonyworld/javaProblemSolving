# Problem - 재귀함수를 이용한 팩토리얼 (개념잡기용)

- 해당 섹션은 개념잡기용 강의이기에 Model Solution을 빠르게 학습하고 넘어간다.

## KeyWord

- 재귀함수
- 스택프레임

## Problem Requirements

- 첫 번째 줄에 자연수 (1≤N≤100)이 입력됨

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
	public int dfs(int n) {
		if (n == 1) {
			return 1;
		}

		return n * dfs(n - 1);
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		bw.write(String.valueOf(T.dfs(n)));

		bw.flush();
		bw.close();
		br.close();
	}
}
```

## What I Learned

- 5 * DFS(4) -> 5 * (4 * DFS(3)) -> 5 * (4 * (3 * (DFS(2)))  
  -> 5 * (4 * (3 * (2 * DFS(1)))) -> 5 * 4 * 3 * 2 * 1
- 재귀함수의 스택프레임으로 인해 실제 연산은 1 * 2 * 3 * 4 * 5 = 120 순서로 진행된다.
- 스택 프레임이 POP될 때 해당 프레임은 완전히 사라지지만, 반환값은 CPU 레지스터에 잠시 저장된다.
- 상위 호출자는 레지스터의 값을 복사해 사용하기 때문에, 다시 하위 함수를 호출할 필요가 없다.
- 스택 프레임에는 매개변수, 지역 변수, 리턴 주소는 포함되지만, 반환값은 레지스터에 저장된 후 상위 호출자의 스택 프레임에서 복사되어 사용된다.
