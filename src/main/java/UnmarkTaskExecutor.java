import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnmarkTaskExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^unmark (\\d+)$");

    public UnmarkTaskExecutor() {
    }

    @Override
    public boolean run(String command, List<Task> tasks) {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            int index = Integer.parseInt(matcher.group(1)) - 1;
            if (0 <= index && index < tasks.size()) {
                tasks.get(index).markAsUndone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.printf("\t%s\n", tasks.get(index));
            }
            return true;
        }
        return false;
    }
}
