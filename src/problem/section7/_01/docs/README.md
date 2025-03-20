# Problem - 재귀함수를 이용한 1 ~ N까지 출력하기 (개념잡기용)

- 해당 섹션은 개념잡기용 강의이기에 Model Solution을 빠르게 학습하고 넘어간다.

## KeyWord

- 재귀함수
- 스택프레임

## Problem Requirements

- 첫 번째 줄은 정수 (3≤N≤10)이 입력됨

## Problem Approach Strategy

- 스택 프레임을 활용 함수의 호출이 모두 끝난 뒤에 해당 함수가 호출되기 이전 상태로 돌아가는게 핵심

## Model Solution

```java
import java.io.*;

public class Main {

	public void dfs(int n, BufferedWriter bw) throws IOException {
		if (n == 0)
			return;

		dfs(n - 1, bw);
		bw.write(n + " ");
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
<img width="915" alt="Image" src="https://github.com/user-attachments/assets/926ff136-ddf3-4239-b540-de3c9577d655" />
- 스택 프레임(Stack Frame)이란 함수가 호출될 때, 그 함수만의 스택 영역을 구분하기 위하여 생성되는 공간이다. 
- 이 공간에는 함수와 관계되는 지역 번수, 매개변수,복귀주소가 저장되며, 함수 호출 시 할당되며, 함수가 종료되면서 소멸한다.
- dfs()의 함수내용을 전부 실행한 후 스택프레임이 사라지면서 자기가 호출되었던 주소로 복귀하게 된다.  
