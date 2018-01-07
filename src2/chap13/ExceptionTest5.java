package chap13;

/* TODO: [Fixie]
 * 第13章 例外 p.101
 * 問題13-3 List13-8の問題です。
 *
 * コンパイルエラー解消のために
 * 「...」をコメントアウトしています。
 * そのままコメント行ごと削除しちゃってきちんと動くように修正してみましょう！
 *
 */
public class ExceptionTest5 {
    public static void main(String[] args) {
        try {
            method1(0);
            method2(0);
            method3(0);
        } catch (Exception e) {
            System.out.println("例外:" + e);
        }
    }
    static void method1(int x) throws Exception {
//        ...
    }
    static void method2(int x) throws Exception {
//        ...
    }
    static void method3(int x) throws Exception {
//        ...
    }
}
