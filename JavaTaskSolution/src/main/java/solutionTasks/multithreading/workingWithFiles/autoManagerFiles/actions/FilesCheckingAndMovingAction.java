package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * при вызове экземпляра класса, стартует отдельный поток, который выполняет выполняет следующе:
 * 1. Получает с установленной директории источника по умолчанию все файлы
 * 2. Выполняет поиск целового списока файлов для перемещения указанного с консоли
 * 3. перемещает список файлов в директорию указанную по умолчанию
 *
 * */
public class FilesCheckingAndMovingAction implements Action {

    private final String sourcePath = "E:\\proba\\";
    final String targetPath = "E:\\proba\\target";
    private Thread chekAndMoveThread;
    public String matchSymbols;


    public FilesCheckingAndMovingAction(String matchSymbols) throws IOException {
        this.matchSymbols = matchSymbols;
        chekAndMoveThread = new Thread(this, "chekAndMoveThread");
        chekAndMoveThread.start();
    }

    public Set<String> listFilesUsingFilesList() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(sourcePath))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }

    public Set<String> targetListFiles() throws IOException {
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

    public void moveTargetListFiles() throws IOException {
        String FILE_TO_MOVE;
        String TARGET_FILE = null;

        for (String fileName :
                targetListFiles()) {
            FILE_TO_MOVE = sourcePath + "\\" + fileName;
            TARGET_FILE = targetPath + "\\" + fileName;
            Files.move(Paths.get(FILE_TO_MOVE), Paths.get(TARGET_FILE));
            System.out.println("File "+fileName +" moved to directory: " + targetPath);
        }
    }

    @Override
    public void run() {
        try {
            moveTargetListFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Your file was successfully moving to the path "
                + this.targetPath +
                "! \nTo finish print 'exit'.");
    }

    public Thread getCheckThread() {
        return chekAndMoveThread;
    }
}