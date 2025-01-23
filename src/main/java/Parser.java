import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    public static Command parse(String fullCommand) {
        Matcher matcher = BASIC_COMMAND_FORMAT.matcher(fullCommand);
        if (!matcher.matches()) {
            return new IncorrectCommand();
        }
        
        String commandWord = matcher.group("commandWord");
        String arguments = matcher.group("arguments");
        return switch (commandWord) {
            case TodoCommand.COMMAND_WORD -> prepareTodo(arguments);
            case DeadlineCommand.COMMAND_WORD -> prepareDeadline(arguments);
            case EventCommand.COMMAND_WORD -> prepareEvent(arguments);
            case ListCommand.COMMAND_WORD -> new ListCommand();
            case DeleteCommand.COMMAND_WORD -> prepareDelete(arguments);
            case MarkCommand.COMMAND_WORD -> prepareMark(arguments);
            case UnmarkCommand.COMMAND_WORD -> prepareUnmark(arguments);
            case ByeCommand.COMMAND_WORD -> new ByeCommand();
            default -> new IncorrectCommand();
        };
    }

    public static Command prepareTodo(String arguments) {
        String taskName = arguments.trim();
        if (taskName.isEmpty()) {
            return new IncorrectCommand("OOPS!!! The description of a todo cannot be empty.");
        }
        return new TodoCommand(taskName);
    }

    public static Command prepareDeadline(String arguments) {
        final Pattern PATTERN = Pattern.compile("^(.+) /by (\\d{4}-\\d{2}-\\d{2})$");
        Matcher matcher = PATTERN.matcher(arguments);
        if (matcher.matches()) {
            String taskName = matcher.group(1);
            try {
                LocalDate by = LocalDate.parse(matcher.group(2));
                return new DeadlineCommand(taskName, by);
            } catch (DateTimeParseException e) {
                return new IncorrectCommand();
            }
        }
        return new IncorrectCommand();
    }

    public static Command prepareEvent(String arguments) {
        final Pattern PATTERN = Pattern.compile("^(.+) /from (\\d{4}-\\d{2}-\\d{2}) /to (\\d{4}-\\d{2}-\\d{2})$");
        Matcher matcher = PATTERN.matcher(arguments);
        if (matcher.matches()) {
            String taskName = matcher.group(1);
            try {
                LocalDate from = LocalDate.parse(matcher.group(2));
                LocalDate to = LocalDate.parse(matcher.group(3));
                return new EventCommand(taskName, from, to);
            } catch (DateTimeParseException e) {
                return new IncorrectCommand();
            }
        }
        return new IncorrectCommand();
    }

    public static Command prepareDelete(String arguments) {
        try {
            int index = Integer.parseInt(arguments.trim());
            return new DeleteCommand(index - 1);
        } catch (NumberFormatException e) {
            return new IncorrectCommand();
        }
    }

    public static Command prepareMark(String arguments) {
        try {
            int index = Integer.parseInt(arguments.trim());
            return new MarkCommand(index - 1);
        } catch (NumberFormatException e) {
            return new IncorrectCommand();
        }
    }

    public static Command prepareUnmark(String arguments) {
        try {
            int index = Integer.parseInt(arguments.trim());
            return new UnmarkCommand(index - 1);
        } catch (NumberFormatException e) {
            return new IncorrectCommand();
        }
    }
}
