import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1517 {
	static long cnt = 0;
	static int[] tmp = {};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		tmp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		merge(arr, 0, arr.length - 1);

		System.out.println(cnt);
		br.close();
	}

	public static void merge(int[] arr, int start, int end) {
		if (end - start < 1)
			return;
		int mid = start + (end - start) / 2;
		merge(arr, start, mid);
		merge(arr, mid + 1, end);

		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}

		int idx = start, idx2 = mid + 1, i = start;
		while (idx <= mid && idx2 <= end) {
			if (tmp[idx] > tmp[idx2]) {
				arr[i] = tmp[idx2];
				cnt += idx2++ - i++;
			} else {
				arr[i++] = tmp[idx++];
			}
		}

		while (idx <= mid) {
			arr[i++] = tmp[idx++];
		}

		while (idx2 <= end) {
			arr[i++] = tmp[idx2++];
		}
	}
}