package 실습.반복문.삼각형;

import java.util.Scanner;

public class 길어진역직각삼각형 {
//	  0 *********
//	  1 *******
//	  2 *****
//	  3 ***
//	  4 *
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("n의 값 : ");
			n = sc.nextInt();
		} while(n <= 0);
		
		System.out.println("길어진 역 직각 삼각형");
		for(int i = 0; i < n; i++) {
			System.out.printf("%3d ", i);
			for(int j = 0; j < 2*(n-i)-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
