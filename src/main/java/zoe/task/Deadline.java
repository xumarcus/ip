package zoe.task;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@Data
public class Deadline extends Task {
    private final String taskName;
    private final LocalDate by;

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
