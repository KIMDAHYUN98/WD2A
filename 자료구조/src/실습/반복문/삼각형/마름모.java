package 실습.반복문.삼각형;

import java.util.Scanner;

public class 마름모 {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("n의 값 : ");
			n = sc.nextInt();
		} while (n <= 0);

		System.out.println("마름모");
		
		// 윗 부분
		for(int i = 0; i < n; i++) {
			System.out.printf("%3d ", i);
			for(int j = 0; j < n -i -1; j++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j <= i * 2; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		// 아랫부분
		for(int i = 0; i < n-1; i++) {
			System.out.printf("%3d ", i+n);
			for(int j = 0; j < i+1; j++) {
				System.out.print(" ");
			}
			// 2 *(n-i-1)-1
			for(int j = 0; j < n-(i*2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
	}
	
}
