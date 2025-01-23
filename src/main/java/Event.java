import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Event extends Task {
    private final String taskName;
    private final String from;
    private final String to;

    @Override
    public String getTypeIcon() {
        return "E";
    }

    @Override
    public String getDescription() {
        return String.format("%s (from: %s to: %s)", taskName, from, to);
    }
}
