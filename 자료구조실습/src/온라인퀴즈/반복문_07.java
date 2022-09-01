package 온라인퀴즈;

public class 반복문_07 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				sum = sum + j;
				i = i + 1;
			}
		}
		System.out.println(sum);
	}
}
