import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkTaskExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^mark (\\d+)$");
    public MarkTaskExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            int index = Integer.parseInt(matcher.group(1)) - 1;
            if (taskList.hasIndex(index)) {
                Task task = taskList.get(index);
                task.markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.printf("\t%s\n", task);
            }
            return true;
        }
        return false;
    }
}
