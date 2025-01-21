import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodoExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^todo(.+)$");

    public TodoExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) throws ZoeException {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            String taskName = matcher.group(1).trim();
            if (taskName.isEmpty()) {
                throw new ZoeException("OOPS!!! The description of a todo cannot be empty.");
            }
            Task task = new ToDo(taskName);
            taskList.add(task);
            return true;
        }
        return false;
    }
}
