
package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    private String sourcePath;
    private String targetPath;
    private Thread copyThread;

    public FileCopyAction(String sourcePath, String targetPath) {
        this.sourcePath = sourcePath;
        this.targetPath = targetPath;
        copyThread = new Thread(this, "copyFile");
        copyThread.start();
    }


    @Override
    public void run() {
        try {
            Files.copy(Paths.get(sourcePath), Paths.get(targetPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Your file was successfully copied to the path " + this.targetPath +
                "! \nTo finish print 'exit'.");
    }

    public Thread getCopyThread() {
        return copyThread;
    }
}