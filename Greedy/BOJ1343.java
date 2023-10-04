package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] poly = new String[] {"AAAA", "BB"};
		StringBuffer sb = new StringBuffer();
		String tmp = br.readLine();

		tmp = tmp.replaceAll("XXXX", poly[0]);
		tmp = tmp.replaceAll("XX", poly[1]);

		if (tmp.contains("X"))
			System.out.println(-1);
		else
			System.out.println(tmp);
	}
}
