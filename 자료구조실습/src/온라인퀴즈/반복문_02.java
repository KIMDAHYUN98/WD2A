package 온라인퀴즈;

public class 반복문_02 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				for(int k = 0; k < 10; k++) 
				{
					sum = sum + 1;
				}
			}
		}
		System.out.println(sum);
	}
}
