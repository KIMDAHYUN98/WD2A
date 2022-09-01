package 온라인퀴즈;

public class 반복문_08 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				sum = sum + 2;
			}
		}
		
		System.out.println(sum);
	}
}
