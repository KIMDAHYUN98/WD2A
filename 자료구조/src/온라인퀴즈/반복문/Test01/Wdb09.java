package 온라인퀴즈.반복문.Test01;

public class Wdb09 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(i > 3 && j < 3)
				{
					sum = sum + i;
				}
			}
		}
		System.out.println(sum);
	}
}
