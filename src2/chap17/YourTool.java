package chap17;


public class YourTool {
    public static void main(String[] args) {
        PublicTool obj = new PublicTool();  // ○publicなクラスはアクセスできる
        Tool obj = new Tool();              // ×publicでないクラスはアクセスできない
    }
}
