package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * класс позволяет определить наличие файлов в каталоге
 * и переместить определённые файлы по заданному названию в
 * указанный каталог.
 * команда: fileCheck
 * путь: E:\\proba\\xx123.txt
 * */
public class FileCheckAction implements Action {

    private static String sourcePath;
    private Thread checkThread;
    Set<String> setFiles;
    public String fileName;
    private String targetPath = "E:\\proba\\target";

    public FileCheckAction(String sourcePath) throws IOException {
        this.sourcePath = sourcePath;
        this.setFiles = new HashSet<>();
        checkThread = new Thread("checkFile");
        checkThread.start();
    }

    // наличие файлов в указанной директории
    public static Set<String> listFilesUsingFilesList() throws Exception {
        try (Stream<Path> filesStream = Files.list(Paths.get(sourcePath))) {
            return filesStream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public void run() {
        // имя целевой директории с именем файла
        String fullPath;

        //  проверка на наличие файлов в директории
        try {
            if (!listFilesUsingFilesList().isEmpty()) {
                setFiles = listFilesUsingFilesList();
                Iterator<String> iter = setFiles.iterator();
                for (String el : listFilesUsingFilesList()) {
                    el = iter.next();
                    if (el.contains("xx123")) {
                        el = fileName;
                        fullPath = targetPath + "/" + fileName;
                        System.out.println(el);
//                  перемещение файла из одного каталага в другой
                        Files.createFile(Paths.get(fullPath));
                        Files.copy(Paths.get(sourcePath), Paths.get(fullPath),
                                StandardCopyOption.REPLACE_EXISTING);
                        Files.delete(Paths.get(sourcePath));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void close() throws Exception {
        System.out.println("Your file was successfully copied to the path " + this.targetPath +
                "! \nTo finish print 'exit'.");
    }

    public Thread getCheckThread() {
        return checkThread;
    }
}