package 온라인퀴즈.반복문.Test02;
public class Wdb12 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 100; j++) {
                if (j < 3 && j > j - 1) {
                    sum = sum + 1;
                }
            }
        }
        System.out.println(sum);
        return;
    }
}
