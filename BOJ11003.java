import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ11003 {
	static class Pair {
		int value;
		int index;
		Pair (int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		Deque<Pair> deque = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());

		arr[0] = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			while (!deque.isEmpty() && deque.peekLast().value > arr[i]) {
				deque.pollLast();
			}
			deque.addLast(new Pair(arr[i], i));
			if (deque.peekFirst().index <= i - l) {
				deque.pollFirst();
			}

			bw.write(deque.peekFirst().value + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}