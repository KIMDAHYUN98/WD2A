package 실습.알고리즘;

import java.util.Scanner;

public class SumWhile {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("n의 값을 입력하시오 : ");

		int n = sc.nextInt();
		int i = 1, sum = 0;

		// 정해진 횟수 X, 조건식이 true 일 때만 반복
		// 조건식이 false가 되면 반복문을 종료한다.
		while (i <= n) {
			sum += i; // sum = sum + i
			i++; // i = i + 1;
		}

		System.out.println("1부터 n까지의 합계 : " + sum);

	}
}
