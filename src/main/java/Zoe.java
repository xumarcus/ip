import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Zoe\nWhat can I do for you?\n");

        List<Executor> executors = new ArrayList<>();
        executors.add(new ListExecutor());
        executors.add(new MarkTaskExecutor());
        executors.add(new UnmarkTaskExecutor());
        executors.add(new TodoExecutor());
        executors.add(new DeadlineExecutor());
        executors.add(new EventExecutor());
        executors.add(new DefaultExecutor());

        TaskList taskList = new TaskList();
        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equals("bye")) break;
            for (Executor executor : executors) {
                try {
                    if (executor.run(command, taskList)) break;
                } catch (ZoeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
