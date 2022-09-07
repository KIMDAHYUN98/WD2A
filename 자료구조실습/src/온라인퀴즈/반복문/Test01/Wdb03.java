package 온라인퀴즈.반복문.Test01;

public class Wdb03 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				for(int k = 0; j < 3; j++)
				{
					sum = sum + 1;
				}
			}
		}
		System.out.println(sum);
	}
}

/*
 * 
1번 150
2번 1500
3번 12
4번 10
5번 10
6번 45
7번 190
8번 100
9번 12
10번 40
11번 3
12번 6
13번 24
 */
