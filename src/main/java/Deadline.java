import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Deadline extends Task {
    private final String taskName;
    private final String by;

    @Override
    public String getTypeIcon() {
        return "D";
    }

    @Override
    public String getDescription() {
        return String.format("%s (by: %s)", taskName, by);
    }
}
