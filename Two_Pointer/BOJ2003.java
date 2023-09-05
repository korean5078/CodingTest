package Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
		int[] arr = new int[n];
		int a = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			arr[a++] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		int start = 0, end = 0;

		while (start <= end) {
			if (end >= arr.length) {
				break;
			}
			int sum = 0;
			for (int i = start; i <= end; i++) {
				sum += arr[i];
			}

			if (sum < m) {
				end++;
			} else if (sum > m) {
				start++;
				if (start > end) {
					end++;
				}
			} else {
				cnt++;
				end++;
			}
		}

		System.out.println(cnt);
		br.close();
	}
}