import java.util.List;

public class AddTaskExecutor implements Executor {
    public AddTaskExecutor() {
    }

    @Override
    public boolean run(String command, List<Task> tasks) {
        tasks.add(new Task(command));
        System.out.printf("added: %s\n", command);
        return true;
    }
}
