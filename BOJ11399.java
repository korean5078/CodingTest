import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] sum = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int idx = 0;
			int min = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) {
				if (min > arr[j]) {
					min = arr[j];
					idx = j;
				}
			}
			int tmp = arr[idx];
			arr[idx] = arr[i];
			arr[i] = tmp;
		}

		sum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}

		int ans = 0;
		for (int i : sum) {
			ans += i;
		}

		System.out.println(ans);
		br.close();
	}
}