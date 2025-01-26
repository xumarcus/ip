package zoe.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zoe.storage.Storage;
import zoe.task.Task;
import zoe.task.TaskList;
import zoe.ui.Ui;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class FindCommand implements Command {
    public static final String COMMAND_WORD = "find";
    private final String keyword;

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) {
        List<Task> matchingTasks = taskList.stream()
                .filter(task -> task.getTaskName().contains(keyword))
                .collect(Collectors.toList());
        ui.showList(matchingTasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
