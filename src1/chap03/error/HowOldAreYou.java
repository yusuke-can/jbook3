package chap03.error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {
    public static void main(String[] args) {
        System.out.println("あなたの名前を入力してください。");
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            line = reader.readLine();
            System.out.println(line + "さん、こんにちは。");
            System.out.println("年齢を入力してください。");
            line = reader.readLine();
            age = Integer.parseInt(line);
            System.out.println("いま " + age + " 歳とすると、10年後は " + age + 10 + " 歳ですね。");
        } catch (IOException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println("年齢が正しくありません。");
        }
    }
}
