package app_a.chap09.A9_6;

public class ShowMaxData {
    public static void main(String[] args) {
        int[] data = { 31, 41, 59, 26, 53, 58, 97, 93, 23, 84 };
        int max_data = data[0];
        for (int i = 0; i < data.length; i++) {
            max_data = Math.max(max_data, data[i]);
        }
        System.out.println("最大値は" + max_data + "です。");
    }
}
