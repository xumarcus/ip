package zoe.task;

import java.time.LocalDate;
/**
 * Represents a task with a deadline. A {@code Deadline} is a subclass of {@code Task}
 * that includes a specified due date.
 *
 * <p> Each {@code Deadline} has the following:
 * <ul>
 *     <li>A task name, which describes the task.</li>
 *     <li>A deadline date, which specifies when the task is due.</li>
 * </ul>
 *
 * <p>The class also provides methods to retrieve a type icon and a formatted task
 * description indicating the deadline date.
 */
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDate by;

    public Deadline(String taskName, LocalDate by) {
        super(taskName);
        this.by = by;
    }

    @Override
    public String getTypeIcon() {
        return "D";
    }

    @Override
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        return String.format("%s (by: %s)", taskName, by.format(formatter));
    }
}
