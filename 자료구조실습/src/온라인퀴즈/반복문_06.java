package 온라인퀴즈;

public class 반복문_06 {
	public static void main(String[] args) {
		int sum = 0;
 		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				sum = sum + i;
				i = i + 1;
			}
		}
		System.out.println(sum);
	}
}
