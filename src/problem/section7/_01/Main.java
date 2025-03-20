package problem.section7._01;

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
