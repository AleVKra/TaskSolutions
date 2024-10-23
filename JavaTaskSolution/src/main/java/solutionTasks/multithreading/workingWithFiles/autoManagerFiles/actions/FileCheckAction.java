package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * класс позволяет определить наличие файлов в каталоге
 * и переместить определённые файлы по заданному названию в
 * указанный каталог.*/
public class FileCheckAction implements Action {

    private String sourcePath;
    private Thread checkThread;
    private String fileName;
    private String targetPath = "E:/proba/target";


    public FileCheckAction(String sourcePath, String fileName) throws IOException {
        this.sourcePath = sourcePath;
        this.fileName = fileName;
        listFilesUsingFilesList();
        checkThread = new Thread("checkFile");
        checkThread.start();
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

    @Override
    public void run() {
//          полное имя директории с именем файла
        String fullPath = targetPath + "/" + fileName;
//  проверка на наличие файлов в директории
        try {
            if (!listFilesUsingFilesList().isEmpty()) {
//  получение названия файла с его проверкой и соответствия
                String etalon = "xx123";
                char[] strFinish = new char[5];
                for (String failName : listFilesUsingFilesList()) {
                    StringBuilder strName = new StringBuilder(failName);
                    for (int i = 0; i < strName.length(); i++) {
//   если первые 5 символов "xx123"
                        if (i < 5) {
                            for (int j = 0; j < strFinish.length; j++) {
                                strFinish[i] = strName.charAt(i);
                            }
//      проверка полученного результата с эталоном, при соответствии переместить в указанный каталог
                            if (strFinish.toString().equals(etalon)) {
                                Files.createFile(Paths.get(fullPath));
                                Files.copy(Paths.get(sourcePath), Paths.get(fullPath),
                                        StandardCopyOption.REPLACE_EXISTING);
                                Files.delete(Paths.get(sourcePath));
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
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