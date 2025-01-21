import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnmarkTaskExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^unmark (\\d+)$");
    public UnmarkTaskExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            int index = Integer.parseInt(matcher.group(1)) - 1;
            if (taskList.hasIndex(index)) {
                Task task = taskList.get(index);
                task.markAsUndone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.printf("\t%s\n", task);
            }
            return true;
        }
        return false;
    }
}
