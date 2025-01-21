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
        executors.add(new AddTaskExecutor());

        List<Task> tasks = new ArrayList<>();
        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equals("bye")) break;
            for (Executor executor : executors) {
                if (executor.run(command, tasks)) break;
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
