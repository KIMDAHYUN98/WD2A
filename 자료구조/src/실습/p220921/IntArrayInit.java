package 실습.p220921;

import java.util.Arrays;
import java.util.Random;

public class IntArrayInit {
	
	static int maxOf(int[] arr)
	{
		int max;
		max = arr[0];
		for(int i = 0; i < arr.length - 1; i++)
		{
			if(arr[i+1] > max) max = arr[i+1];
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		//int[] a = {22, 57, 11, 91, 32};
		int[] a = new int[5];
		
		for(int i = 0; i < a.length; i++)
		{
			a[i] = random.nextInt(100); // 0 ~ 99 까지의 숫자를 랜덤으로 출력
			System.out.println(a[i]);
			//System.out.println("a[" + i + "]=" + a[i]);
		}
		System.out.println("arr의 최댓값은 " + maxOf(a) + "입니다.");
		
		reverse(a);
		
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] + ", ");
		}
		
		System.out.println("\n a.toString() : " + a.toString());
		System.out.println("\n Arrays.toString(a) : " + Arrays.toString(a));
		
		System.out.println("\n 역순으로 정렬하는 과정");
		reverse1(a);
		System.out.println("\n 모든 요소의 합을 출력");
		sum(a);
		System.out.println("\n 모든 요소를 역순으로 복사");
		int[] b = {1,2};
		rcopy(a, b);
		
	}
	private static void rcopy(int[] a, int[] b) {
		// TODO Auto-generated method stub
		
	}


	private static void sum(int[] a) {
		// TODO Auto-generated method stub
		
	}


	private static void reverse1(int[] a) {
		// TODO Auto-generated method stub
		
	}


	// 배열의 원소의 순서를 역순으로 만드는 메소드
	private static void reverse(int[] arr) {
		for(int i = 0; i < arr.length/2; i++)
		{
			// 두 원소의 값을 바꾼다.
			swap(arr, i, arr.length-i-1);
		}
	}

	// 배열에서의 지정한 두 원소의 값을 교환
	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
}
