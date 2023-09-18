import java.util.Scanner;

public class BOJ3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] arr2 = new int[1000001];
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();

		int x = sc.nextInt();

		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (x - arr[i] < 1000001 && x - arr[i] >= 0) {
				if(arr2[x- arr[i]] == 1) {
					cnt++;
					arr2[x-arr[i]]++;
				}
			}
			arr2[arr[i]]++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
