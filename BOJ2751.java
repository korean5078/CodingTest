import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2751 {
	static int[] tmp = {};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		tmp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		merge(arr, 0, arr.length - 1);

		for (int i : arr) {
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
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

		int index = start, index2 = mid + 1;
		int i = start;

		while (index <= mid && index2 <= end) {
			if (tmp[index] > tmp[index2]) {
				arr[i++] = tmp[index2];
				index2++;
			} else {
				arr[i++] = tmp[index];
				index++;
			}
		}

		while (index <= mid) {
			arr[i++] = tmp[index++];
		}

		while (index2 <= end) {
			arr[i++] = tmp[index2++];
		}
	}
}