package 실습.알고리즘;

import java.util.Scanner;

public class Max3 {
	public static void main(String[] args) {

		// 객체 변수 생성
		Scanner stdIn = new Scanner(System.in);
		// new Scanner : 스캐너 객체 생성
		// System.in 매개변수를 줘서 스캐너 객체 생성 후 만든 객체를 stdIn 객체 변수에 담는다

		System.out.println("세 정수의 최댓값을 구합니다.");
		// println 메서드를 통해 화면에 데이터를 출력
		// java.lang에 system이라는 클래스가 있고 out이라는 변수가 있음
		// PrintStream 클래스의 out 인스턴스(=filed) 변수임
		System.out.println("a의 값: ");
		int a = stdIn.nextInt();
		System.out.println("b의 값: ");
		int b = stdIn.nextInt();
		System.out.println("c의 값: ");
		int c = stdIn.nextInt();
		// 정수형 n을 생성하고 stdIn 변수 안에 들어있는 Scanner 클래스의 nextInt라는 메서드를 실행
		// int형 정수를 입력받는 메서드
		// input의 다음토큰을 정수로 입력받는다.
		// 키보드로부터 입력받은 값을 정수로 인식하여 입력 받는다.

		int max = a;
		if (b > max)
			max = b;
		if (c > max)
			max = c;

		System.out.println("최댓값은 " + max + "입니다.");

	}
}
