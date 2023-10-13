package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ1260 {
	static List<Integer>[] lists;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), v = Integer.parseInt(input[2]);
		lists = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			lists[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
			lists[a].add(b);
			lists[b].add(a);
		}

		visited[v] = true;
		dfs(v);
		System.out.println();

		visited = new boolean[n + 1];
		bfs(v);

		br.close();
	}

	public static void dfs(int n) {
		System.out.print(n + " ");
		visited[n] = true;
		Collections.sort(lists[n]);
		for (int i : lists[n]) {
			if (!visited[i])
				dfs(i);
		}
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			System.out.print(tmp + " ");

			for (int i : lists[tmp]) {
				if (visited[i])
					continue;
				visited[i] = true;
				queue.add(i);
			}
		}
	}
}