package 온라인퀴즈.반복문.Test02;
public class Wdb07 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				sum = sum + i;
				i = i + 1;
			}
		}
		System.out.println(sum);
		return;
	}
}