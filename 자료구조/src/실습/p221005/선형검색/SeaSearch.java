package 실습.p221005.선형검색;

import java.util.Random;
import java.util.Scanner;

public class SeaSearch {
	
		static int seqSearch(int[] a, int n, int key) {
			int i = 0;
			
			while(true) {
				if(i==n)
					return -1;
				if(a[i] == key)
					return i;
				i++;
			}
		}

	
	public static void main(String[] args) {
	// 100개의 랜덤한 정수값(0에서 100까지의 정수)을 가진 배열을 생성하고
	// 여기에서 5가 들어 있는 배열의 인덱스를 검색하시오.
	// 못 찾으면 못 찾았다고 출력하시오.
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		
//		System.out.println("요솟수 :");
		int num = 100;
		int[] x = new int[num];
		
		for(int i = 0; i < num; i++) {
//			x[i] = stdIn.nextInt();
			x[i] = rand.nextInt(100);
			System.out.print("x[" + i + "]: ");
			System.out.println(x[i]);
			
		}
		
		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();
		int idx = seqSearch(x, num, ky);
		
		if(idx == -1)
			System.out.println("검색 값의 요소가 없습니다.");
		else 
			System.out.println("검색 값은 x[" + idx + "]에 있습니다.");
	}
}
