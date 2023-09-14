import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int start = 1, end = 1, cnt = 0;

		while (start <= n && end <= n) {
			long m = (end * (end + 1) - start * (start - 1)) / 2;
			if (m > n) {
				start++;
			} else {
				if (m == n) {
					cnt++;
				}
				end++;
			}
		}

		System.out.println(cnt);

		br.close();
	}
}