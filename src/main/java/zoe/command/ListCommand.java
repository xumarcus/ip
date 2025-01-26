package zoe.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import zoe.storage.Storage;
import zoe.task.TaskList;
import zoe.ui.Ui;

@Getter
@NoArgsConstructor
public class ListCommand implements Command {
    public static final String COMMAND_WORD = "list";

    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) {
        ui.showList(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
