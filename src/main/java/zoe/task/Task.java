package zoe.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Task {
    public enum TaskStatus {
        DONE,
        UNDONE
    }
    @Getter
    protected final String taskName;
    protected TaskStatus status = TaskStatus.UNDONE;

    public String getStatusIcon() {
        return switch (status) {
            case DONE -> "X";
            case UNDONE -> " ";
        };
    }

    public abstract String getTypeIcon();

    public abstract String getDescription();

    public void markAsDone() {
        status = TaskStatus.DONE;
    }

    public void markAsUndone() {
        status = TaskStatus.UNDONE;
    }

    public String getFullDescription() {
        return String.format("[%s][%s] %s", getTypeIcon(), getStatusIcon(), getDescription());
    }
}