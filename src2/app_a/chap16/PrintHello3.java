package app_a.chap16;

/* [Fixie]補足:
 * 第16章 スレッド p.188 問題16-3
 * p.334の解答からクラス名を
 *
 * LabelPrinter -> LabelPrinter3
 *
 * に変更しました。
 *
 * PrintHelloクラス内のLabelPrinterクラスとクラス名が重複しており、
 * クラス宣言がパッケージプライベート
 * （public, protected, privateのいずれもclassの前についていない）
 * であることから、
 *
 * PrintHello3メソッド内で呼び出すLabelPrinterメソッドが
 * ・PrintHelloクラス内のLabelPrinterクラス
 * ・PrintHello3クラス内のLabelPrinterクラス
 * のどちらにもアクセス可能であり（同じパッケージ内にあるので）
 * コンパイラがどちらのクラスを呼び出しているのか判別できずに
 * コンパイルエラーになってしまっていました。
 *
 * 第17章 パッケージ P.202
 * 「パッケージとアクセス制御」
 * アクセス制御とは何か
 * を参照。
 *
 * 「パッケージプライベート」とは
 *
 * P.203のページ上部の表の
 * ２行目の
 *
 * なし 自分のパッケージに見せる名前
 *
 * のことを指しています。（正式名称ですよ！ググってみてね）
 *
 */
class LabelPrinter3 extends Thread {
    String label = "no label";
    LabelPrinter3(String label) {
        this.label = label;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println(label);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class PrintHello3 {
    public static void main(String[] args) {
        new LabelPrinter3("おはよう！").start();
        new LabelPrinter3("こんにちは！").start();
        new LabelPrinter3("こんばんは！").start();
    }
}
