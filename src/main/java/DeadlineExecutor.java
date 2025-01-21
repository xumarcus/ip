import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeadlineExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^deadline (.+) /by (.+)$");

    public DeadlineExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            String taskName = matcher.group(1);
            String by = matcher.group(2);
            Task task = new Deadline(taskName, by);
            taskList.add(task);
            return true;
        }
        return false;
    }
}
