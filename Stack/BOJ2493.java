package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
	int index;
	int height;

	Top(int index, int height) {
		this.height = height;
		this.index = index;
	}

	public int getHeight() {
		return this.height;
	}

	public int getIndex() {
		return this.index;
	}
}
public class BOJ2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		Stack<Top> stack = new Stack<>();
		int[] result = new int[input];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int i = 0;

		while(st.hasMoreTokens()) {
			Top tmp = new Top(i+1, Integer.parseInt(st.nextToken()));

			if (!stack.isEmpty()) {
				// if (stack.peek().getHeight() >= tmp.getHeight()) {
				// 	stack.push(tmp);
				// } else {
				// 	tmp = stack.pop();
				// }
				while(!stack.isEmpty()) {
					if (stack.peek().getHeight() >= tmp.getHeight()) {
						result[i] = stack.peek().getIndex();
						break;
					} else
						stack.pop();
				}
			}
			stack.push(tmp);

			// if (stack.isEmpty())
			// 	stack.push(tmp);

			// result[i++] = tmp;
			i++;
		}

		for (int j : result) {
			System.out.print(j + " ");
		}
	}
}