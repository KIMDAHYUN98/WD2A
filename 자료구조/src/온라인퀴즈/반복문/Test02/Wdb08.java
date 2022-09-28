package 온라인퀴즈.반복문.Test02;
public class Wdb08 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 20; j++) {
                sum = sum + j;
                i = i + 1;
            }
        }
        System.out.println(sum);
        return;
    }
}
