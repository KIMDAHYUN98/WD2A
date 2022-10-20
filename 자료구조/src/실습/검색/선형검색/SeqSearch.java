package 실습.검색.선형검색;

import java.util.Scanner;

public class SeqSearch {
	
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;

		while(true) {
			if(i == n)
				return -1;
			if(a[i] == key)
				return i;
			i++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		int[] x = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = sc.nextInt();
		
		// 검색할 값의 위치를 반환한다.
		int idx = seqSearch(x, n, key);
		
		if(idx == -1)
			System.out.println("검색 값의 요소가 없습니다.");
		else
			System.out.println("검색 값은 x[" + idx + "]에 있습니다.");
		
	}
}
