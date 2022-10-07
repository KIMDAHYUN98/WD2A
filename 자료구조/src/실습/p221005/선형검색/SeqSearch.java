package 실습.p221005.선형검색;

import java.util.Random;
import java.util.Scanner;

public class SeqSearch {
	// 버블 정렬	
	static void bubbleSort(int[] a, int n) {
			for(int i = 0; i < n-1; i++) {
				for(int j = n-1; j > i; j--) {
					if(a[j-1] > a[j]) {
						swap(a, j-1, j);
					}
				}
			}
		}
	
	private static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
		static int seqSearch(int[] a, int n, int key) {
			int i = 0;
			
			
//			while(true) {
//				if(i==n)
//					return -1;
//				if(a[i] == key)
//					return i;
//				i++;
//			}
			
			a[n] = key;
			
			while(true) {
				if (a[i] == key) {
					break;
				}
				i++;
			}
			
			if(i == n) {
				return -1;
			}
			
			return i;
		}

	static int binarySearch(int[] a, int n, int key) {
		// pl : 왼쪽, pr : 오른쪽 위치, pc : 중간 위치
		int pl, pr, pc;
		pl = 0;
		pr = n-1;
		
		do {
			pc = (pl + pr) / 2;
			if(a[pc] == key) {
				return pc;
			} else if (a[pc] < key) { // 검색범위가 오른쪽으로 변경
				pl = pc + 1;
			} else { // 검색범위가 왼쪽으로 변경
				pr = pc - 1;
			}
		} while(pl <= pr);
		
		return -1;
	}
	
	public static void main(String[] args) {
	// 100개의 랜덤한 정수값(0에서 100까지의 정수)을 가진 배열을 생성하고
	// 여기에서 5가 들어 있는 배열의 인덱스를 검색하시오.
	// 못 찾으면 못 찾았다고 출력하시오.
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		
//		System.out.println("요솟수 :");
		int num = 100;
		int[] x = new int[num+1];
		
		for(int i = 0; i < num; i++) {
//			x[i] = stdIn.nextInt();
			x[i] = rand.nextInt(100);
			System.out.print("x[" + i + "]: ");
			System.out.println(x[i]);	
		}
		
		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();
//		int idx = seqSearch(x, num, ky);
		
		System.out.println("\n 버블 정렬");
		SeqSearch.bubbleSort(x, num);
		for(int i = 0; i < num; i++) {
//			x[i] = stdIn.nextInt();
			x[i] = rand.nextInt(100);
			System.out.print("x[" + i + "]: ");
			System.out.println(x[i]);	
		}
		
		
		System.out.println("\n 이진 검색");
		int idx = SeqSearch.binarySearch(x, num, ky);
		
		if(idx == -1)
			System.out.println("검색 값의 요소가 없습니다.");
		else 
			System.out.println("검색 값은 x[" + idx + "]에 있습니다.");
	}
}
