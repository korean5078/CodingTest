package Recursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println((1<<n) - 1);
		func(1, 3, n);

		System.out.println(sb);
	}

	public static void func(int a, int b, int n) {
		if (n== 1) {
			//System.out.println(a + " " + b);
			sb.append(a + " " + b + "\n");
			return;
		}

		func(a, 6-a-b, n - 1);
		func(a,b ,1);
		func(6-a-b , b, n-1);
	}
}