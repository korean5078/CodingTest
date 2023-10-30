package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 0, end = k - 1;
        long median = 0;
        while (start <= end) {
            long sum = 0;
            median = (start + end) / 2;
            for (long i = 1; i <= n; i++) {
                sum += Math.min(median / i, n);
            }

            if (sum >= k) {
                end = median - 1;
            } else {
                start = median + 1;
            }
        }

        System.out.println(start);
        br.close();
    }
}