package problem.section7._04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	// solution 1
	// public int dfs(int n) {
	// 	if (n == 1)
	// 		return 1;
	// 	else if (n == 2)
	// 		return 1;
	// 	else
	// 		return dfs(n - 1) + dfs(n - 2);
	// }
	//
	// public static void main(String[] args) throws IOException {
	// 	Main T = new Main();
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	int n = Integer.parseInt(br.readLine());
	//
	// 	for (int i = 1; i <= n; i++) {
	// 		bw.write(String.valueOf(T.dfs(i) + " "));
	// 	}
	//
	// 	bw.flush();
	// 	bw.close();
	// 	br.close();
	// }

	// solution 2
	// static int[] fibo;
	//
	// public int dfs(int n) {
	// 	if (n == 1)
	// 		return fibo[n] = 1;
	// 	else if (n == 2)
	// 		return fibo[n] = 1;
	// 	else
	// 		return fibo[n] = dfs(n - 1) + dfs(n - 2);
	// }
	//
	// public static void main(String[] args) throws IOException {
	// 	Main T = new Main();
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	int n = Integer.parseInt(br.readLine());
	// 	fibo = new int[n + 1];
	// 	T.dfs(n);
	//
	// 	for (int i = 1; i <= n; i++) {
	// 		bw.write((fibo[i] + " "));
	// 	}
	//
	// 	bw.flush();
	// 	bw.close();
	// 	br.close();
	// }

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
