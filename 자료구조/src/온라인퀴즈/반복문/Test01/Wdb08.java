package 온라인퀴즈.반복문.Test01;

public class Wdb08 {
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
