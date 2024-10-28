package solutionTasks.workingWithFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleMoveFiles {

    private final static String sourcePath = "E:\\proba";
    final static String targetPath = "E:\\proba\\target";
    /*
     * Задание:
     * получить спискок файлов из указанной папке в целевую по указанному названию
     * */


    public static void main(String[] args) throws IOException {
        System.out.println(listFilesUsingFilesList().toString());
        System.out.println(targetListFiles().toString());
        /*перемещение файлов в основном методе*/
        moveTargetListFiles();
    }

    /*3. перемещение списка целевых файлов в целевую директорию*/
    public static void moveTargetListFiles() throws IOException {
        String FILE_TO_MOVE;
        String TARGET_FILE = null;
        if (!targetListFiles().isEmpty()) {
            for (String fileName :
                    targetListFiles()) {
                FILE_TO_MOVE = sourcePath + "\\" + fileName;
                TARGET_FILE = targetPath + "\\" + fileName;
                Files.move(Paths.get(FILE_TO_MOVE), Paths.get(TARGET_FILE));
//            Path fileToMovePath = Paths.get(FILE_TO_MOVE);
//            Path targetPath = Paths.get(TARGET_FILE);
//            Files.move(fileToMovePath, targetPath);
                System.out.println("Files moved to directory: " + targetPath);
            }
        } else {
            System.out.println("Sorry, there are no files available to move!");
        }
    }


    /* 2. получение списка целевых файлов для перемещения*/
    public static Set<String> targetListFiles() throws IOException {
        String matchSymbols = "123";
        Set<String> setTarget = new HashSet<>();

        if (!listFilesUsingFilesList().isEmpty()) {
            Iterator<String> iter = listFilesUsingFilesList().iterator();
            for (String el : listFilesUsingFilesList()) {
                el = iter.next();
                if (el.contains(matchSymbols)) {
                    setTarget.add(el);
                }
            }
        }
        return setTarget;
    }

    /*1. получение всех файлов из папки источника*/
    public static Set<String> listFilesUsingFilesList() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(sourcePath))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }
}
