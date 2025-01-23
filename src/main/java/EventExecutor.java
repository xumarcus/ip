import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class EventExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^event (.+) /from (.+) /to (.+)$");

    @Override
    public boolean run(String command, TaskList taskList) {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            String taskName = matcher.group(1);
            LocalDate from = LocalDate.parse(matcher.group(2));
            LocalDate to = LocalDate.parse(matcher.group(3));
            Task task = new Event(taskName, from, to);
            taskList.add(task);
            return true;
        }
        return false;
    }
}
