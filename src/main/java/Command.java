public interface Command {
    void execute(Storage storage, TaskList taskList, Ui ui) throws ZoeException;
    boolean isExit();
}
