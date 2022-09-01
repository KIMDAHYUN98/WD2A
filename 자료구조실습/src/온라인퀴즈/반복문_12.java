package 온라인퀴즈;

public class 반복문_12 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				if(j < i)
				{
					sum = sum + 1;
				}
			}
		}
		
		System.out.println(sum);
	}
}
