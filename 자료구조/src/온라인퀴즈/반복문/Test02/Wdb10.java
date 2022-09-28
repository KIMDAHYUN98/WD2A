package 온라인퀴즈.반복문.Test02;
public class Wdb10 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 30; j++) {
                if (i > 2 && j < 5) {
                    sum = sum + i;
                }
            }
        }
        System.out.println(sum);
        return;
    }
}
