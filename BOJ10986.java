import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
		int[] arr = new int[n];
		long[] sum = new long[n];
		long[] count = new long[m];
		long cnt = 0;
		inputs = br.readLine().split(" ");
		for (int i = 0; i < inputs.length; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}

		sum[0] = arr[0];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i-1] + arr[i];
		}

		for (int i = 0; i < sum.length; i++) {
			int tmp = (int) (sum[i] % m);
			if (tmp == 0) {
				cnt++;
			}
			count[tmp]++;
		}

		for (int i = 0; i < count.length; i++) {
			long tmp = count[i];
			cnt += (tmp * (tmp - 1) / 2);
		}

		System.out.println(cnt);

		br.close();
	}
}