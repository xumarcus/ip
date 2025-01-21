interface Executor {
    boolean run(String command, TaskList taskList) throws ZoeException;
}
