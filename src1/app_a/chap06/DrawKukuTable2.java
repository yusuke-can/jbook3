package app_a.chap06;

public class DrawKukuTable2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d*%d=%-4d", i, j, i * j);
            }
            System.out.println("");
        }
    }
}
