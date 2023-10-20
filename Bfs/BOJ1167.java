package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ1167 {
	static class Pair {
		int edge;
		int distance;
		Pair(int e, int d) {
			this.distance = d;
			this.edge = e;
		}
	}

	static List<Pair>[] lists;
	static boolean[] visited;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		lists = new List[n + 1];
		distance = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < lists.length; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			int v = Integer.parseInt(inputs[0]);
			for (int j = 1; j < inputs.length - 1; j+=2) {
				lists[v].add(new Pair(Integer.parseInt(inputs[j]), Integer.parseInt(inputs[j + 1])));
			}
		}
		bfs(1);
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (distance[i] > distance[max])
				max = i;
		}
		distance = new int[n + 1];
		visited = new boolean[n + 1];
		bfs(max);
		Arrays.sort(distance);
		System.out.println(distance[n]);
		br.close();
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (Pair i : lists[tmp]) {
				if (!visited[i.edge]) {
					visited[i.edge] = true;
					queue.add(i.edge);
					distance[i.edge] = distance[tmp] + i.distance;
				}
			}
		}
	}
}