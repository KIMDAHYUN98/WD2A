package 온라인퀴즈.반복문.Test02;
public class Wdb14 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 30; j++) {
                if (j > i) {
                    sum = sum + 1;
                }
            }
        }
        System.out.println(sum);
        return;
    }
}
