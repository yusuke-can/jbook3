package chap16;

import java.text.SimpleDateFormat;
import java.util.Date;

class Runner extends Thread {
    private boolean running = true;
    public void stopRunning() {
        running = false;
    }
    @Override
    public void run() {
        while (running) {
            doCommand();
        }
    }

    /**
     * 現在日時を 書式：yyyy/MM/dd HH:mm:ss で出力
     *
     * [Fixie]補足：サンプルではdoCommandメソッドが未実装だったので追加.
     */
    private void doCommand() {
      SimpleDateFormat daateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      System.out.println(daateFormatter.format(new Date()));
    }
}
