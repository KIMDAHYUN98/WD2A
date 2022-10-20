package 실습.검색.이진검색;

import java.util.Random;
import java.util.Scanner;

// 22-10-12
public class BinarySearch {
	
	static int binarySearch(int[] a, int n, int key) {
		int pl = 0; // 검색 범위의 첫 인덱스
		int pr = n - 1; // 검색 범위의 끝 인덱스
		
		do {
			int pc = (pl + pr) / 2; // 중앙 요소 인덱스
			if(a[pc] == key)
				return pc; // 검색 성공!
			else if(a[pc] < key)
				pl = pc + 1; // 검색 범위를 뒤쪽 절반으로 좁힘
			else
				pr = pc + 1; // 검색 범위를 앞쪽 절반으로 좁힘
		} while(pl <= pr);
		
		return -1; // 검색 실패
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
		
		BinarySearch.binarySearch(x, num, ky);
	}
}
