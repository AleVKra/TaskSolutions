
package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Действие, которое создает новые файлы.
 */
public class FileCreateAction implements Action {
    private String path;
    private Thread createThread;

    public FileCreateAction(String path) {
        this.path = path;
        createThread = new Thread(this, "createFile");
        createThread.start();
    }

    @Override
    public void run() {
        try {
            Files.createFile(Paths.get(path));
        } catch (IOException ignored) {
        }
    }

    @Override
    public void close() {
        System.out.println("Your file was successfully created! \nTo finish print 'exit'.");
    }

    public Thread getCreateThread() {
        return createThread;
    }
}