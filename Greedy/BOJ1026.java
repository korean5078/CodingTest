package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];

		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(inputs[i]);
		}

		inputs = br.readLine().split(" ");
		for (int i = 0; i < b.length; i++) {
			b[i] = Integer.parseInt(inputs[i]);
		}
		int ans = 0;
		Arrays.sort(a);
		int max = -999, tmp = -999;
		ArrayList prev = new ArrayList();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (prev.contains(j)) continue;
				if (max < b[j]) {
					max = b[j];
					tmp = j;
				}
			}
			ans += max * a[i];
			prev.add(tmp);
			max = -999;
		}
		System.out.println(ans);
	}
}
