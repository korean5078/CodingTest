package Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ15565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				list.add(i);
			}
		}

		if (list.size() < k) {
			System.out.println(-1);
			return;
		}

		int start = 0, end = k - 1, ans = n;
		while (end < list.size()) {
			int sum = list.get(end) - list.get(start) + 1;
			if (ans > sum) {
				ans = sum;
			}
			end++;
			start++;
		}

		System.out.println(ans);
		br.close();
	}
}