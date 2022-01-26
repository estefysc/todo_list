import java.util.Scanner;

public class Launcher {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        TodoList todoList = new TodoList(s);
        int exitCode = 1;

        while(exitCode != 0) {
            todoList.displayMenu();
            // todo -- if a string is inputted instead of an int, the program will crash.
            int selection = s.nextInt();
            s.nextLine();
            exitCode = todoList.executeMenuSelection(selection);
        }

        s.close();
    }
}
