import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TodoList {
    private LinkedList<String> todoList;
    private Iterator iterator;
    private Scanner classScanner;
    private String item;
    private int optionToDelete;
    private int listIndex;
    private int returnCode;
    private int itemNumber;

    public TodoList(Scanner s) {
        todoList = new LinkedList<>();
        classScanner = s;
        item = null;
        optionToDelete = 0;
        listIndex = 0;
        returnCode = 1;
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("You can add, delete, or simply view the items in the to-do list.");
        System.out.println("Enter 1 to display the current list.");
        System.out.println("Enter 2 to add an item to the list.");
        System.out.println("Enter 3 to delete an item from the list.");
        System.out.println("Enter 0 to exit the program.");
        System.out.println();
        System.out.println("Enter your selection:");
    }

    public int executeMenuSelection(int option) {
        switch(option) {
            case 0:
                System.out.println();
                returnCode = 0;
                System.out.println("You have ended the program!");
                break;
            case 1:
                displayList();
                break;
            case 2:
                addItem(classScanner);
                break;
            case 3:
                deleteItem(classScanner);
                break;
            default:
                System.out.println();
                System.out.println("Please enter a valid option");
        }
        return returnCode;
    }

    private void addItem(Scanner s) {
        System.out.println();
        System.out.println("Enter the item to add.");
        item = s.nextLine();
        todoList.add(item);
        System.out.println();
        System.out.println("Your item has been added!");
    }

    private void deleteItem(Scanner s) {
        displayList();
        System.out.println("--------------");

        if(!todoList.isEmpty()) {
            System.out.println("Enter the number of the item to be deleted.");
            optionToDelete = s.nextInt();
            listIndex = optionToDelete - 1;

            if(listIndex < 0 || optionToDelete > todoList.size()) {
                System.out.println();
                System.out.println("That is not a valid option. Please try Again.");
                deleteItem(classScanner);
            } else {
                todoList.remove(listIndex);
                System.out.println();
                System.out.println("Your item has been deleted!");
            }
        } else {
            System.out.println("Add an item first.");
        }
    }

    private void displayList() {
        itemNumber = 1;

        if(todoList.isEmpty()) {
            System.out.println();
            System.out.println("Your to-do list is empty.");
        } else {
            iterator = todoList.listIterator();
            System.out.println();
            System.out.println("Here is your list:");
            while (iterator.hasNext()) {
                System.out.print(itemNumber + "- ");
                System.out.println(iterator.next());
                itemNumber++;
            }
        }
    }
}
