package 온라인퀴즈.반복문.Test01;

public class Wdb07 {
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
