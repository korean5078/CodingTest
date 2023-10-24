package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];

        inputs = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            binarySearch(arr, 0, n - 1, arr2[i]);
        }

        br.close();
    }
    public static void binarySearch(int[] arr, int start, int end, int x) {
        if (x > arr[end] || x < arr[start]) {
            System.out.println(0);
            return;
        }

        if (x == arr[(start + end)/2]) {
            System.out.println(1);
            return;
        }

        if (arr[(start + end)/2] > x) {
            binarySearch(arr, start, (start+end)/2 - 1, x);
        }
        if (arr[(start + end)/2] < x) {
            binarySearch(arr, (start+end)/2 + 1, end, x);
        }
    }
}