package app_i;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileN {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("使用法：java DeleteFileN 削除ファイル");
            System.out.println("例：java DeleteFileN trash.txt");
            System.exit(0);
        }
        String filename = args[0];
        try {
            Path path = Paths.get(filename);
            Files.delete(path);
            System.out.println(filename + "を削除しました。");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
