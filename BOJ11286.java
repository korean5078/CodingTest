import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);
			}
		});

		for (int i = 0; i < n; i++) {
			int input = scanner.nextInt();
			if (input != 0) {
				queue.add(input);
			} else {
				if (queue.peek() == null) {
					System.out.println(0);
				} else {
					System.out.println(queue.poll());
				}
			}
		}

		scanner.close();
	}
}