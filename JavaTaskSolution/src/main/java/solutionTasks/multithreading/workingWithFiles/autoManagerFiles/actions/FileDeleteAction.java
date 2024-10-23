
package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Действие, которое удаляет файлы.
 */
public class FileDeleteAction implements Action {
    private String path;
    private Thread deleteThread;

    public FileDeleteAction(String path) {
        this.path = path;
        deleteThread = new Thread(this, "deleteFile");
        deleteThread.start();
    }

    @Override
    public void run() {
        try {
            Files.delete(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        System.out.println("Your file was successfully deleted!" +
                " \nTo finish print 'exit'.");
    }

    public Thread getDeleteThread() {
        return deleteThread;
    }
}