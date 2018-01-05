package app_i;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RenameFileN {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("使用法：java RenameFileN 現在のファイル名 新しいファイル名");
            System.out.println("例：java RenameFileN old.txt new.txt");
            System.exit(0);
        }
        String oldfilename = args[0];
        String newfilename = args[1];
        try {
            Path oldpath = Paths.get(oldfilename);
            Path newpath = Paths.get(newfilename);
            Files.move(oldpath, newpath);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
