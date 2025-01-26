package zoe.task;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    public void testGetDescriptionConformsToDateFormat() {
        Event event = new Event("Birthday Party", LocalDate.of(2023, 12, 24), LocalDate.of(2023, 12, 25));
        String description = event.getDescription();
        assertEquals("Birthday Party (from: Dec 24 2023 to: Dec 25 2023)", description,
                "Expected description format did not match.");
    }
}
