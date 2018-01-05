package app_i;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListDirN {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("使用法：java ListDirN ディレクトリ名");
            System.out.println("例：java ListDirN doc");
            System.exit(0);
        }
        String dirname = args[0];
        try {
            try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get(dirname))) {
                for (Path path : dirs) {
                    System.out.println(path);
                }
            } catch (DirectoryIteratorException e) {
                throw e.getCause();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
