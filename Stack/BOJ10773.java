package Stack;

import java.util.Scanner;

public class BOJ10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] stack = new int[100000];
		int top = -1;

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			if (input == 0)
				stack[top--] = 0;
			else
				stack[++top] = input;
		}
		int sum = 0;
		for (int i = 0; i <= top; i++)
			sum += stack[i];

		System.out.println(sum);

		sc.close();
	}
}
