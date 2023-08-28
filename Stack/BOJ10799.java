package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		int sum = 0;
		Stack stack = new Stack();

		if (input[0].equals("("))
			stack.push(input[0]);

		for (int i = 1; i < input.length; i++) {
			if (input[i].equals(")")) {

				if (!stack.isEmpty()) {
					stack.pop();
				}

				if (input[i-1].equals("(")) {
					sum += stack.size();
				} else {
					sum += 1;
				}


			} else {
				stack.push(input[i]);
			}
		}
		System.out.println(sum);
	}
}