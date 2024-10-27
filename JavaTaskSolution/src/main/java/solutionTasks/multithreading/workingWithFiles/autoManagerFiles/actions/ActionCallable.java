package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.actions;

import java.util.Set;
import java.util.concurrent.Callable;

public interface ActionCallable extends Callable<Set>, AutoCloseable {

    @Override
    public Set call() throws Exception;
}
