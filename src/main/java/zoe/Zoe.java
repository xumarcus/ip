package zoe;

import zoe.command.Command;
import zoe.command.Parser;
import zoe.storage.Storage;
import zoe.task.TaskList;
import zoe.ui.Ui;

public class Zoe {
    private final Storage storage;
    private final Ui ui;
    private TaskList taskList;

    public Zoe(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load());
        } catch (ZoeIOException e) {
            taskList = new TaskList();
        }
    }

    public static void main(String[] args) {
        new Zoe("data/zoe.txt").run();
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showDividerLine();
                Command c = Parser.parse(fullCommand);
                c.execute(storage, taskList, ui);
                isExit = c.isExit();
            } catch (ZoeException e) {
                ui.showError(e);
            } finally {
                ui.showDividerLine();
            }
        }
    }
}
