package 온라인퀴즈.반복문.Test02;
public class Wdb11 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 100; j++) {
				if (i < 3 || j > 4) {
					sum = sum + 1;
				}
			}
		}
		System.out.println(sum);
		return;
	}
}