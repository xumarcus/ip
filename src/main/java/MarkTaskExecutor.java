import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkTaskExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^mark (\\d+)$");
    public MarkTaskExecutor() {
    }

    @Override
    public boolean run(String command, List<Task> tasks) {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            int index = Integer.parseInt(matcher.group(1)) - 1;
            if (0 <= index && index < tasks.size()) {
                tasks.get(index).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.printf("\t%s\n", tasks.get(index));
            }
            return true;
        }
        return false;
    }
}
