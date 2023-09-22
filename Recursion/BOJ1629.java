package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1629 {
	static int sum = 1;
	static int a, b, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		a = Integer.parseInt(inputs[0]);
		b = Integer.parseInt(inputs[1]);
		c = Integer.parseInt(inputs[2]);

		System.out.println(func(b));

	}

	public static long func(int n) {
		if (n == 1) {
			return (a%c);
		}

		long val = func(n / 2);
		if (n %2 == 1) {
			return val * val % c * a % c;
		} else {
			return val * val % c;
		}
	}
}