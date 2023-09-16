import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1377 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Pair[] arr = new Pair[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair(Integer.parseInt(br.readLine()), i);
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			if (cnt < arr[i].index - i)
				cnt = arr[i].index - i;
		}

		System.out.println(cnt + 1);

		br.close();
	}

	static class Pair implements Comparable<Pair> {
		int value;
		int index;

		Pair (int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Pair p1) {
			return this.value - p1.value;
		}
	}
}