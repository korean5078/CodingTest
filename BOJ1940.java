import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] inputs = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int i = 0;
		while (st.hasMoreTokens()) {
			inputs[i++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputs);

		int start = 0, end = n - 1, cnt = 0;

		while (start < end) {
			int sum = inputs[start] + inputs[end];
			if (sum > m) {
				end--;
			} else if (sum < m) {
				start++;
			} else {
				cnt++;
				end--;
				start++;
			}
		}
		System.out.println(cnt);
	}
}