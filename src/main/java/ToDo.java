import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ToDo extends Task {
    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public String getTypeIcon() {
        return "T";
    }

    @Override
    public String getDescription() {
        return taskName;
    }
}
