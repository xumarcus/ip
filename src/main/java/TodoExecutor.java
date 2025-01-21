import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodoExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^todo (.+)$");

    public TodoExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            String taskName = matcher.group(1);
            Task task = new ToDo(taskName);
            taskList.add(task);
            return true;
        }
        return false;
    }
}
