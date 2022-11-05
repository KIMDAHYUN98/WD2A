package 실습.큐;

import java.util.Random;

public class WDB2 {
	static int NUM = 100;

	public static void main(String args[]) {
		IntArrayQueue q = new IntArrayQueue(20);
		Random rand = new Random();

		for (int i = 0; i < 100; i++) {
			if (q.isFull()) {
				System.out.println("full 발생");
				while (!q.isEmpty()) {
					System.out.printf("[%d] %d 디큐 (front = %d, rear = %d, num = %d)\n", i + 1, q.deque(), q.front,
							q.rear, q.num);
				}
				System.out.println("empty 발생");
			}
			int n = rand.nextInt(101);
			q.enque(n);
			System.out.printf("[%d] %d 인큐 (front = %d, rear = %d, num = %d)\n", i + 1, n, q.front, q.rear, q.num);
		} // end of for

	} // end of main
}
