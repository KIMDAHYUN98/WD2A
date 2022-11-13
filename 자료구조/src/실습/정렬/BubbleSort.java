package 실습.정렬;

public class BubbleSort {

	public static void main(String args[]) {
		System.out.println("버블 정렬 v1.0");
		int nx = 8;
		int[] x = { 7, 6, 4, 3, 7, 1, 9, 8 };


		BubbleSort.bubbleSort(x, nx);
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		int ccnt = 0;
		int scnt = 0;
		for (int i = 0; i < n - 1; i++) {
			System.out.printf("패스%d\n", i + 1);
			for (int j = n - 1; j > i; j--) {
				for (int k = 0; k < n; k++) {
					System.out.printf("%2d %c", a[k], (k != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
				}
				System.out.println();

				ccnt++;
				if (a[j - 1] > a[j]) {
					scnt++;
					swap(a, j - 1, j);
				}

			}
			for (int k = 0; k < n; k++) {
				System.out.printf("%2d%2c", a[k], ' ');
			} 
			System.out.println();
		}

	}

	// 배열 출력
	static void print(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.printf("x[%d]=%d\n", i, a[i]);
		}
	}

}
