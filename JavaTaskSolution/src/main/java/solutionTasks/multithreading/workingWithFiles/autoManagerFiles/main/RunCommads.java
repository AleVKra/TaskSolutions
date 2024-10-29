package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.main;


import solutionTasks.multithreading.workingWithFiles.autoManagerFiles.actions.*;
import solutionTasks.multithreading.workingWithFiles.autoManagerFiles.console.ConsoleUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class RunCommads extends ConsoleUI<Commands> {

    public static void main(String[] args) {
        new RunCommads().run();
    }

    RunCommads() {
        super(Commands.class);
    }

    @Override
    protected void onCommand(Commands command) throws IOException {
        String sourcePath;
        String targetPath;
        String[] fileName;
        BufferedReader reader;
        String charactersEncountered;
        switch (command) {
            case create:
                reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Target directory of the new file: ");
                targetPath = reader.readLine();
                FileCreateAction createAction = new FileCreateAction(targetPath);
                createAction.start();
                if (createAction.getCreateThread().isAlive()) {
                    try {
                        createAction.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case copy:

                reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Source directory of file to be copied: ");
                sourcePath = reader.readLine();
                System.out.print("Target directory of the copied file: ");
                targetPath = reader.readLine();
                FileCopyAction copyAction =
                        new FileCopyAction(sourcePath, targetPath);
                if (copyAction.getCopyThread().isAlive()) {
                    try {
                        copyAction.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case move:
                /*
                 * E:/proba/xx123.txt
                 * E:/proba/target
                 */
                reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Source directory of file to be moved: ");
                sourcePath = reader.readLine();
                fileName = sourcePath.split("/");
                System.out.print("Target directory of the moved file: ");
                targetPath = reader.readLine();
                FileMoveAction moveAction =
                        new FileMoveAction(sourcePath, targetPath, fileName[fileName.length - 1]);
                if (moveAction.getMoveThread().isAlive()) {
                    try {
                        moveAction.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case delete:
                reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Source directory of file to be deleted: ");
                targetPath = reader.readLine();
                FileDeleteAction deleteAction = new FileDeleteAction(targetPath);
                if (deleteAction.getDeleteThread().isAlive()) {
                    try {
                        deleteAction.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case fileCheckAndMove:
                reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("write the characters that occur in the file name: ");
                charactersEncountered =reader.readLine();
                FilesCheckingAndMovingAction checkAction =
                        new FilesCheckingAndMovingAction(charactersEncountered);
                if (checkAction.getCheckThread().isAlive()) {
                    try {
                        checkAction.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case exit:
                close();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }

}