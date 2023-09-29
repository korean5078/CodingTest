package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ11724 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		boolean[] visited = new boolean[n + 1];
		Stack<Integer> stack = new Stack<>();
		int first = 0;

		List<Integer>[] lists = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			if (i == 0)
				first = Integer.parseInt(input[0]);
			lists[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			lists[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {

			if (visited[i]) {
				continue;
			}
			stack.add(i);
			visited[i] = true;

			while (!stack.isEmpty()) {
				int tmp = stack.pop();
				for (int j = 0; j < lists[tmp].size(); j++) {
					int u = lists[tmp].get(j);
					if (!visited[u]) {
						stack.add(u);
						visited[u] = true;
					}
				}
			}
			ans++;
		}


		System.out.println(ans);
		br.close();
	}
}