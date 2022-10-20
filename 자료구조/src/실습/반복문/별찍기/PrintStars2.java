package 실습.반복문.별찍기;

import java.util.Scanner;

public class PrintStars2 {
	public static void main(String[] args) {
		

		System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력한다.");
		
		int n, w;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("n 값 : ");
		n = sc.nextInt();
		System.out.print("w 값 : ");
		w = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.print("*");
			if(i % w == w -1)
				System.out.println();
		}
		System.out.println();
		System.out.println(n/w + "줄 만큼만 반복");
		for(int i = 0; i < n/w; i++)
			System.out.println("*".repeat(w));
		// repeat(int count)
		// repeat : 반복하다
		// String 클래스의 메서드인 repeat를 호출한다.
		// 지정한 카운트 갯수 만큼 해당 문자열을 반복한다.
		
		int rest = n % w; // 총 별자리 갯수에다가 줄바꿈 갯수 나눈 나머지
		System.out.println(rest + " 나머지 갯수 만큼만 반복");
		if(rest != 0) // 나머지가 0이 아니라면
			System.out.println("*".repeat(rest));
		
	}
}
