package zoe.task;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a Todo task.
 * A Todo task is a basic task type with a name and no additional date-related constraints.
 * <p>
 * Extends the {@link Task} class, utilizing its core functionality such as task status management
 * and description-related retrieval, while customizing its type icon and description format.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Todo extends Task {
    private final String taskName;

    @Override
    public String getTypeIcon() {
        return "T";
    }

    @Override
    public String getDescription() {
        return taskName;
    }
}
