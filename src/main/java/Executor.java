import java.util.List;

interface Executor {
    boolean run(String command, List<Task> tasks);
}
