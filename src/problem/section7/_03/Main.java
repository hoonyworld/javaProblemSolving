package problem.section7._03;

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
