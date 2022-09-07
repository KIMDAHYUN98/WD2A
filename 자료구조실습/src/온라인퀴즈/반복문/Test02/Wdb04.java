package 온라인퀴즈.반복문.Test02;
public class Wdb04 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; j < 3; j++) {
                    sum = sum + 1;
                }
            }
        }
        System.out.println(sum);
        return;
    }
}
