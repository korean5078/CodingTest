import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split("");
		int[] arr = new int[inputs.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			int max = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[max] < arr[j]) {
					max = j;
				}
			}

			int tmp = arr[max];
			arr[max] = arr[i];
			arr[i] = tmp;
		}

		// int max = Integer.MIN_VALUE;
		// int idx = 0;
		// for (int i = 0; i < arr.length; i++) {
		// 	for (int j = i; j < arr.length; j++) {
		// 		if (max < arr[j]) {
		// 			max = arr[j];
		// 			idx = j;
		// 		}
		// 	}
		//
		// 	int tmp = arr[idx];
		// 	arr[idx] = arr[i];
		// 	arr[i] = tmp;
		//
		// 	max = Integer.MIN_VALUE;
		// }

		for (int j : arr) {
			System.out.print(j);
		}

		br.close();
	}
}