import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^event (.+) /from (.+) /to (.+)$");

    public EventExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            String taskName = matcher.group(1);
            String from = matcher.group(2);
            String to = matcher.group(3);
            Task task = new Event(taskName, from, to);
            taskList.add(task);
            return true;
        }
        return false;
    }
}
