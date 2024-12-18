package solutionTasks.multithreading.workingWithFiles.autoManagerFiles.console;

import java.io.IOException;

/**
 * Класс описывает текстовый человеко-машинный интерфейс.
 *
 * @param <E> тип данных, описывающий возможные команды.
 *            Дожен быть перечислением
 */
public class ConsoleUI<E extends Enum<E>> extends EnumReader<E>
        implements Runnable {

    private boolean exit;

    public ConsoleUI(Class<E> cls) {
        super(System.in, cls);
    }

    /**
     * Выполняет обработку следующей команды из потока.
     * <p>
     * Следующая команда, содержащаяся в потоке, связанном
     * с текущим объектом, передаётся на обрабтку в метод
     * onCommand.
     */
    protected void processCommand() {
        try {
            System.out.print("> ");
            onCommand(next());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Алгоритм обработки команд.
     */
    @Override
    public void run() {
        while (!exit) processCommand();
    }

    /**
     * Метод жизненного цикла класса.
     * <p>
     * Вызывается, когда от пользозвателя была получена следующая команда.
     *
     * @param command экземпляр перечисления E. Описывает
     *                пользовательскую команду.
     * @throws IOException в случае ощибки ввода вывода
     */
    protected void onCommand(E command) throws IOException {
    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        exit = true;
    }
}