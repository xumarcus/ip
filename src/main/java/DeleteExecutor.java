import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^delete (\\d+)$");

    public DeleteExecutor() {
    }

    @Override
    public boolean run(String command, TaskList taskList) throws ZoeException {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            int index = Integer.parseInt(matcher.group(1)) - 1;
            taskList.remove(index);
            return true;
        }
        return false;
    }
}
