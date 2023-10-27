package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
        int[] arr = new int[n];
        int start = 0, end = 0;
        inputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
            if (start < arr[i])
                start = arr[i];
            end += arr[i];
        }

        while (start <= end) {
            int sum = 0, count = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0)
                count++;
            if (count > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);

        br.close();
    }
}