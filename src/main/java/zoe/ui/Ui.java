package zoe.ui;

import lombok.NoArgsConstructor;
import zoe.ZoeException;
import zoe.task.Task;
import zoe.task.TaskList;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

@NoArgsConstructor
public class Ui {
    private static final Scanner scanner = new Scanner(System.in);

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showWelcome() {
        System.out.println("Hello! I'm Zoe\nWhat can I do for you?\n");
    }

    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showDividerLine() {
        System.out.println("_______");
    }

    public void showError(ZoeException e) {
        System.out.printf("Error: %s\n", e.getMessage());
    }

    public void showAddedTask(TaskList taskList, Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.printf("\t%s\n", task.getFullDescription());
        System.out.printf("Now you have %d tasks in your list.\n", taskList.size());
    }

    public void showRemovedTask(TaskList taskList, Task task) {
        System.out.println("Noted. I've removed this task:");
        System.out.printf("\t%s\n", task.getFullDescription());
        System.out.printf("Now you have %d tasks in your list.\n", taskList.size());
    }

    public void showList(List<Task> tasks) {
        System.out.println("Here are the matching tasks in your list:");
        for (ListIterator<Task> iter = tasks.listIterator(); iter.hasNext(); ) {
            System.out.printf("%d. %s\n", iter.nextIndex() + 1, iter.next().getFullDescription());
        }
    }

    public void showMarkedTask(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("\t" + task.getFullDescription());
    }

    public void showUnmarkedTask(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("\t" + task.getFullDescription());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
