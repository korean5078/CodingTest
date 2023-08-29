package Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
		int[][] arr = new int[n + 1][n + 1];
		int[][] sums = new int[n + 1][n + 1];
		StringTokenizer st = null;
		int a = 1;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				arr[i][a++] = Integer.parseInt(st.nextToken());
				if (a > n) {
					a = 1;
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				// 1,1 부터 i,j 까지 합
				sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + arr[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			int x1, y1, x2, y2;
			String[] input = br.readLine().split(" ");
			x1 = Integer.parseInt(input[0]);
			y1 = Integer.parseInt(input[1]);
			x2 = Integer.parseInt(input[2]);
			y2 = Integer.parseInt(input[3]);

			System.out.println(sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1]);
		}


		br.close();
	}
}