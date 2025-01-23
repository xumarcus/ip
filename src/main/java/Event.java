import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@Data
public class Event extends Task {
    private final String taskName;
    private final LocalDate from;
    private final LocalDate to;

    @Override
    public String getTypeIcon() {
        return "E";
    }

    @Override
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        return String.format("%s (from: %s to: %s)", taskName, from.format(formatter), to.format(formatter));
    }
}
