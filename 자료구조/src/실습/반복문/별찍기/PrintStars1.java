package 실습.반복문.별찍기;

import java.util.Scanner;

public class PrintStars1 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		// n : *의 출력 총 갯수
		// w : 줄 바꿈
		
		int n, w;
		
		System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력한다.");
		
		// 총 *의 갯수 입력
		do {
			System.out.print("n값 : ");
			n = stdIn.nextInt();
		} while(n <= 0); 
		// n값이 0보다 작거나 같을 때 까지 반복
		
		// 줄바꿈 갯수 입력
		do {
			System.out.print("w값 : ");
			w = stdIn.nextInt();
		} while(w <= 0 || w > n); 
		// w값이 0보다 작고 같거나 w가 n보다 클 때 까지 반복
		
		// i가 0부터 n까지 반복
		for(int i = 0; i < n; i++) {
			// *을 출력
			System.out.print("*");
			// 만약 i에 줄 바꿈 총 갯수를 나눈 후 
			// 나머지가 (줄바꿈 총 갯수 -1)과 같다면
			
			// 7 % 4 == 4 - 1
			if (i % w == w - 1)
				System.out.println(); // 줄바꿈
		}
		
		// 총 * 갯수에 w를 나눈 후 나머지가 0과 같지 않다면
		if(n % w != 0)
			System.out.println(); // 줄바꿈
		
	}
}
