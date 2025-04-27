
import java.util.*;
import java.util.LinkedList;

public class BrowserHistory {

    //Queue to represent the history(FIFO)
    static Queue<String> history = new LinkedList<>();

    //Stack to simulate the Undo functionality (LIFO)
    static Stack<String> deletedHistory = new Stack<>();

    static Scanner sc = new Scanner(System.in);
    
    // Add a website to the history 
    public static void addWebsite(String website) {
        history.offer(website);  // add to the end of the queue(FIFO)
        System.out.println(website + " added to history.\n");
    }

    // Delete the most recent website from history
    public static void deleteWebsite() {
        if (!history.isEmpty()) {
            String removed = history.poll();  // remove from the front of the queue
            deletedHistory.push(removed); // push to stack for undo
            System.out.println(removed + "deleted from history.\n");
        } else {
            System.out.println("No history to delete.\n");
        }
    }

    // Undo the last deletion
    public static void undoDelete() {
        if(!deletedHistory.isEmpty()) {
            String restored = deletedHistory.pop(); // pop from the stack
            history.offer(restored); // add back to the queue
            System.out.println(restored + "restored the history.\n");
        } else {
            System.out.println("No deletion to undo.\n");
        }
    }

    // view the browser history 

    public static void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("History is empty.\n");
        } else {
            System.out.println("Browser History: \n");
            for (String website : history) {
                System.out.println(website);
            }
            System.out.println();  // added the line for seperation
        }
    }

    //Display the menu for the user interaction
    public static void displayMenu() {
        System.out.println("\nBrowser History Menu : ");
        System.out.println("1. Add website");
        System.out.println("2. Delete Website");
        System.out.println("3. Undo Deletion");
        System.out.println("4. View History");
        System.out.println("5. Exit");                      
    }

    public static void main(String[] args) {
     
     while (true) {
        displayMenu();
        System.out.println("Chose an option: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume the new line character after the integer input

        switch (choice) {
            case 1:
                System.out.print("Enter website URL to add: ");
                String website = sc.nextLine();
                addWebsite(website);
                break;
                case 2:
                deleteWebsite();
                break;
                case 3:
                undoDelete();
                break;
                case 4:
                viewHistory();
                break;
                case 5:
                System.out.println("Exiting the program.");
                sc.close();
                return;  // Exit the loop and terminate the program
                default:
                System.out.println("Invalid choice! Please try again.");

            
        }
     }   
  
    }
}