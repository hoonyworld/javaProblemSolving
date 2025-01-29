package problem.section10._02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] dy;

	public int solution(int num) {
		// 돌 개수가 1개이면 dy[0]
		dy[0] = 2;
		dy[1] = 3;

		for (int i = 2; i < num; i++) {
			dy[i] = dy[i - 1] + dy[i - 2];
		}

		return dy[num - 1];
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		dy = new int[num];
		int result = T.solution(num);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
