import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class DeadlineExecutor implements Executor {
    private static final Pattern PATTERN = Pattern.compile("^deadline (.+) /by (.+)$");

    @Override
    public boolean run(String command, TaskList taskList) throws ZoeException {
        Matcher matcher = PATTERN.matcher(command);
        if (matcher.matches()) {
            String taskName = matcher.group(1);
            try {
                LocalDate by = LocalDate.parse(matcher.group(2));
                Task task = new Deadline(taskName, by);
                taskList.add(task);
            } catch (DateTimeParseException e) {
                throw new ZoeException("Unable to parse date");
            }
            return true;
        }
        return false;
    }
}
