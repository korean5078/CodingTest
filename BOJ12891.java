import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int S = Integer.parseInt(inputs[0]), P = Integer.parseInt(inputs[1]);
		char[] input = br.readLine().toCharArray();
		int[] check = new int[4];
		int[] mine = new int[4];
		int cnt = 0, start = 0, end = P;
		inputs = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			check[i] = Integer.parseInt(inputs[i]);
		}

		for (int i = 0; i < P; i++) {
			if (input[i] == 'A') {
				mine[0]++;
			} else if (input[i] == 'C') {
				mine[1]++;
			} else if (input[i] == 'G') {
				mine[2]++;
			} else {
				mine[3]++;
			}
		}

		if (mine[0] >= check[0] && mine[1] >= check[1] && mine[2] >= check[2] && mine[3] >= check[3]) {
			cnt++;
		}

		while(end < S) {
			end++;
			if (input[end - 1] == 'A') {
				mine[0]++;
			} else if (input[end - 1] == 'C') {
				mine[1]++;
			} else if (input[end - 1] == 'G') {
				mine[2]++;
			} else {
				mine[3]++;
			}

			if (input[start] == 'A') {
				mine[0]--;
			} else if (input[start] == 'C') {
				mine[1]--;
			} else if (input[start] == 'G') {
				mine[2]--;
			} else {
				mine[3]--;
			}
			start++;

			if (mine[0] >= check[0] && mine[1] >= check[1] && mine[2] >= check[2] && mine[3] >= check[3]) {
				cnt++;
			}


		}
		System.out.println(cnt);

	}
}