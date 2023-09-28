import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n] ;
		int digit = 1, count = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		while (count != 5) {
			int[] num = new int[10];
			for (int j = 0; j < n; j++) {
				num[(int)(arr[j] / digit) % 10]++;
			}

			for (int j = 1; j < num.length; j++) {
				num[j] += num[j - 1];
			}

			int[] tmp = new int[n];
			for (int j = arr.length - 1; j >= 0; j--) {
				tmp[--num[(int)(arr[j] / digit) % 10]] = arr[j];
			}

			arr = tmp;
			count++;
			digit *= 10;
		}

		for (int i = 0; i < n; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();

		br.close();
	}
}