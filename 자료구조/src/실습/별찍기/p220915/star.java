package 실습.별찍기.p220915;

import java.util.Scanner;

public class star {
	public static void main(String[] args) {
		// n을 입력 받아 n줄의 직각 삼각형 출력
		
		int n;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("n의 값 : ");
		// n 입력
			n = sc.nextInt();
			
		} while(n <= 0);
		
		// 직각 삼각형 출력
		System.out.println("\n직각 삼각형");
		for(int i = 0; i < n; i++) {
			System.out.printf("%3d ", i);
			for(int j = 0; j <= i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 역 직각 삼각형 출력
		System.out.println("\n역 직각 삼각형");
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%3d ", i);
			for(int j = 0; j < n - i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n길어진 직각 삼각형");
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%3d ", i);
			for(int j = 0; j < i * 2 + 1; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n길어진 역 직각 삼각형");
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%3d ", i);
			for(int j = 0; j < 2 * (n-i) -1; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n정삼각형");
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%3d ", i);
			for(int j = 0; j < n - i; j++)
			{
				System.out.print(" ");
			}
			
			for(int j = 0; j <= i * 2; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n아래로 볼록한 정삼각형");
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%3d ", i);
			for(int j = 0; j < i; j++)
			{
				System.out.print(" ");
			}
			
			for(int j = 0; j < 2*(n-i)-1; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n마름모");
		
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%3d ", i);
			for(int j = 0; j < n - i; j++)
			{
				System.out.print(" ");
			}
			
			for(int j = 0; j <= i * 2; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < n-1; i++)
		{
			System.out.printf("%3d   ", i+n);
			for(int j = 0; j < i; j++)
			{
				System.out.print(" ");
			}
			//2 * (n - i - 1) - 1
			for(int j = 0; j < 2*(n-i)-3; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n마름모 2개");
		
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%3d ", i);
			for(int j = 0; j < n - i; j++)
			{
				System.out.print(" ");
			}
			
			for(int j = 0; j <= i * 2; j++)
			{
				System.out.print("*");
			}
			for(int j = 0; j < (n - i - 1) * 2; j++)
			{
				System.out.print(" ");
			}
			
			for(int j = 0; j <= i * 2; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < n-1; i++)
		{
			System.out.printf("%3d   ", i+n);
			for(int j = 0; j < i; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j < 2*(n-i)-3; j++)
			{
				System.out.print("*");
			}
			
			for(int j = 0; j < i*2+2; j++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j < 2*(n-i)-3; j++)
			{
				System.out.print("*");
			}
			System.out.println();
			
		}
		
			}
}
