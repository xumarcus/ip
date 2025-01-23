import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ToDo extends Task {
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
