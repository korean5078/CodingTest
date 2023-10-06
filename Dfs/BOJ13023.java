package Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ13023 {
	static boolean[] visited;
	static List<Integer>[] lists;
	static boolean arrive;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		visited = new boolean[n];
		lists = new List[n];
		arrive = false;

		for (int i = 0; i < n; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int tmp1 = Integer.parseInt(input[0]), tmp2 = Integer.parseInt(input[1]);

			lists[tmp1].add(tmp2);
			lists[tmp2].add(tmp1);
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				Dfs(i, 1);
				if (arrive)
					break;
			}
		}

		if (arrive)
			System.out.println(1);
		else
			System.out.println(0);

		br.close();
	}

	static void Dfs(int n, int depth) {
		if (depth == 5 || arrive) {
			arrive = true;
			return;
		}
		visited[n] = true;
		for (int i : lists[n]) {
			if (!visited[i]) {
				Dfs(i, depth + 1);
			}
		}
		visited[n] = false;
	}
}