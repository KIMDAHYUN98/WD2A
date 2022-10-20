package 실습.반복문.다중루프;

public class Mutil99Table {
	public static void main(String[] args) {
		System.out.println("---구구단 곱셈표---");

//		for(int i=1; i<=9; i++)
//		{
////			System.out.print(2 + " * " + i + " = " + (2*i));
////			System.out.println(3 + " * " + i + " = " + (3*i));
//			System.out.printf("2 * %3d = %3d\t", i, (2*i));
//			System.out.printf("3 * %3d = %3d\t", i, (3*i));
//			System.out.printf("4 * %3d = %3d", i, (4*i));
//			System.out.println();
//		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					System.out.printf("%d * %2d = %2d\t", j, k, (k * j));
				}
				System.out.println();
			}
			System.out.println();

		}
	}
}
