package Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		boolean[] checked = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = 0;
		while (st.hasMoreTokens()) {
			arr[a++] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;

		Arrays.sort(arr);

		int start = 0, end = n - 1, idx = 0;

		while (idx < arr.length) {
			if (start == idx) {
				start++;
				continue;
			}
			if (end == idx) {
				end--;
				continue;
			}

			if (start >= end) {
				idx++;
				start = 0;
				end = n - 1;
				continue;
			}
			int sum = arr[start] + arr[end];
			if (sum == arr[idx]) {
				if (!checked[idx])
					cnt++;
				idx++;
				start = 0;
				end = n - 1;
			} else if (sum < arr[idx]) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println(cnt);
		br.close();
	}
}