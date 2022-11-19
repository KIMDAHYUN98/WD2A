package 실습.정렬.삽입정렬;

public class WDB {
	// 단순 삽입 정렬
	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
	         System.out.printf("처리 a[%d]=[%d]  삽입될 위치: ", i, a[i]);
	         // 1. 삽입될 위치 찾기
	         int j;
	         int tmp = a[i];
	         for (j = 0; j < i; j++) {
	            if (tmp > a[j]) {
	               continue;
	            } else {
	               break;
	            }
	         }
	         System.out.println(j);
	         printRow(a, n);
	         // 2. 삽입될 위치부터 원래 자리까지 밀기
	         for (int k = i; k >= j + 1; k--) {
	            a[k] = a[k - 1];
	         }
	         // 3. 값 삽입
	         a[j] = tmp;
	         
	      } 
	}
	
	// 배열 출력
	   static void printRow(int[] a, int n) {
	      for (int i = 0; i < n; i++) {
	         System.out.printf("%3d", i);
	      }
	      System.out.println("");
	      for (int i = 0; i < n; i++) {
	         System.out.printf("%3d", a[i]);
	      }
	      System.out.println("");
	   }

	// 단순 삽입 정렬2
	   static void insertionSort2(int[] a, int n) {
		      for (int i = 1; i < n; i++) {
		         int k = 0;
		         int cnt = 0;
		         for (int j = i; j >= 0; j--) {
		            if (a[j] > a[i]) {
		               k = j;
		               cnt++;
		            }
		            if (a[j] < a[i] && j > 0) {
		               k = i;
		               if (cnt != 0) {
		                  k = j + 1;
		               }
		               break;
		            }
		         }
		         for (int j = i - 1; j >= k; j--) {
		            swap(a, j, j + 1);
		         }
		      }
		   }

	private static void swap(int[] a, int j, int i) {
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}

	// 배열 출력
	static void print(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("x[" + i + "]=" + a[i]);
		}
	}

	public static void main(String[] args) {
		int nx = 8;
		int[] x = {7, 6, 4, 3, 7, 1, 9, 8};
		
		insertionSort(x, nx);
//		print(x, nx);
//		
//		System.out.println("정렬 후");
//		insertionSort2(x, nx);
//		
//		print(x, nx);
	}
}
