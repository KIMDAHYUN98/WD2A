package 실습.알고리즘;

import java.util.Scanner;

public class SumVerbose1 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		int n;

		System.out.println("1부터 n까지의 합을 구합니다.");

		do {
			System.out.print("n : ");
			n = stdIn.nextInt();
		} while (n <= 0);

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += (i + 1);
			if (i < n - 1)
				System.out.print((i + 1) + " + ");
			else
				System.out.print((i + 1) + " = ");
		}

		System.out.println(sum);
	}
}
