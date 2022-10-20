package 실습.검색.선형검색;

import java.util.Random;
import java.util.Scanner;

public class SeqSearch2 {
	
	private static int bubbleSort(int[] a, int n) {
		for(int i = 0; i < n-1; i++) {
			
		}
		return 0;
	}
	public static void main(String[] args) {
		// 100개의 랜덤한 정수값(0에서 100까지의 정수)을 가진 배열을 생성하고
		// 여기에서 5가 들어 있는 배열의 인덱스를 검색하시오.
		// 못 찾으면 못 찾았다고 출력하시오.
		
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		
		int num = 100;
		int[] x = new int[num+1];
		
		System.out.println("\n 버블 정렬");
		for(int i = 0; i < num; i++) {
			x[i] = rand.nextInt(100);
			System.out.print("x[" + i + "]: ");
			System.out.println(x[i]);	
		}
		
		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();
		
		int idx = bubbleSort(x, num); 
		
		if(idx == -1)
			System.out.println("검색 값의 요소가 없습니다.");
		else 
			System.out.println("검색 값은 x[" + idx + "]에 있습니다.");
		
	}

	
}
