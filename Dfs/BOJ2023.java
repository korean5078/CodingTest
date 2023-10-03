package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Dfs(2, 1, n);
		Dfs(3, 1, n);
		Dfs(5, 1, n);
		Dfs(7, 1, n);

		br.close();
	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	static void Dfs(int number, int digit, int n) {
		if (digit == n) {
			System.out.println(number);
			return;
		}
		for (int i = 1; i < 10; i += 2) {
			if (isPrime(number * 10 + i)) {
				Dfs(number * 10 + i, digit + 1, n);
			}
		}
	}
}
