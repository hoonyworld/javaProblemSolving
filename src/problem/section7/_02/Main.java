package problem.section7._02;

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
