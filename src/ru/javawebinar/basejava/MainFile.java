package ru.javawebinar.basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFile {
    public static void main(String[] args) throws IOException {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/ru/javawebinar/basejava");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        assert list != null;
        for (String name : list) {
            System.out.println(name);
        }

        try (FileInputStream fis = new FileInputStream(filePath)){
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // printTree(Paths.get("./src/ru/javawebinar/basejava"), "");
    }

    public static void printTree(Path path, String mask) throws IOException {
        System.out.println(path.getFileName());
        if (path.toFile().isDirectory())
            try (Stream<Path> pathStream = Files.list(path)) {
                List<Path> pathList = pathStream
                        .sorted(Comparator.comparing((Path p) -> !p.toFile().isDirectory())
                                .thenComparing(Path::getFileName)).toList();
                for (int i = 0; i < pathList.size(); i++) {
                    System.out.printf("%s%s───", mask, i == pathList.size() - 1 ? "└" : "├");
                    printTree(pathList.get(i),
                            String.format("%s%s", mask,
                                    i == pathList.size() - 1 ? "    " : "│   "));
                }
            } catch (AccessDeniedException ex) {
                //ignore
            }
    }
}
