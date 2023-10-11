package Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int[][] board = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int[][] ans = new int[n][m];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		Queue<Pair> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = tmp.charAt(j) - 48;
			}
		}
		queue.add(new Pair(0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Pair tmp = queue.poll();
			for (int i = 0; i <= 3; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (visited[nx][ny])
					continue;
				if (board[nx][ny] == 1) {
					queue.add(new Pair(nx, ny));
					visited[nx][ny] = true;
					ans[nx][ny] = ans[tmp.x][tmp.y] + 1;
				}
			}
		}
		System.out.println(ans[n-1][m-1] + 1);
		br.close();
	}
	static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}