
package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.console;

import java.io.*;

public class EnumReader<E extends Enum<E>> implements Closeable {

    private BufferedReader in;

    private Class<E> cls;

    public EnumReader(InputStream stream, Class<E> cls) {
        this.cls = cls;
        in  = new BufferedReader(new InputStreamReader(stream));
    }

    public final E next() throws IOException {
        try {
            return E.valueOf(cls, in.readLine());
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        in = null;
        cls = null;
    }
}