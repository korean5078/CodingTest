import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int num = 0, cnt = 1;
		for (int i = 0; i < x; i++) {
			num += arr[i];
		}

		int start = 0, end = x, max = num;
		while (end < n) {
			int tmp = num;
			tmp += arr[end++] - arr[start++];
			if (tmp > max) {
				cnt = 1;
				max = tmp;
			} else if (tmp == max) {
				cnt++;
			}
			num = tmp;
		}

		if (max == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
		br.close();
	}
}