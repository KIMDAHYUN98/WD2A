package 실습.p221012.순차검색;

import java.util.Random;

public class searchIdx {
	
	private static int searchIndex(int[] a, int n, int ky, int[] idx) {
		int count = 0;
		for(int i = 0; i< n; i++)
		{
			if(a[i] == ky)
			{
				idx[count++] = i;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		
		
		
		
		int num = 10;
		int[] array = new int[num+1];
		Random random = new Random();
		for(int i=0; i < num; i++)
		{
			array[i] = random.nextInt(10);
			System.out.print("a[" + i + "]=" + array[i]);
			if((i+1) % 10 == 0) 
			{
				System.out.println();
			} else {
				System.out.print(", ");
			}
		}
		
		System.out.println();
		int[] idx = new int[num];
		
		System.out.print("검색 값 : ");
		int ky = 9;
		System.out.println(ky);
		int count = searchIndex(array, num, ky, idx);
		System.out.println("검색 개수는 : " + count + "개 입니다.");
		if(count == 0)
			System.out.println("그 값의 존재하지 않습니다.");
		else {
			for(int i=0; i<count; i++)
				System.out.println("그 값은 x[" + idx[i] + "]에 있습니다.");
		}
 	}

	
	
}
