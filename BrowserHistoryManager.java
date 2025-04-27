
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.LinkedList;

public class BrowserHistoryManager {

    // Method to show current history

    private static void showHistory(LinkedList<String> history) {
     if (history.isEmpty()) {
        System.out.println("No browsing history found.");
     } else {
        System.out.println("Updated Browser History: ");
        for (String site : history) {
            System.out.println("- " + site);
        }
     }
    }

    //method to get the current time stamp

    private static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<String> history = new LinkedList<>(); //Using linked list for easy history removal
        Stack<String> deletedHistory = new Stack<>();

        while (true) {
            System.out.println("\nBrowser History Menu: ");
            System.out.println("1. Add Website");
            System.out.println("2. Delete a specific website");
            System.out.println("3. Undo Deletion");
            System.out.println("4. View History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String input = sc.nextLine();
            int choice ;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.Please enter a number!");
                continue; //go back to the menue
            }
            

            switch (choice) {
                case 1:
                System.out.println("Enter the website URL to add: ");
                String url = sc.nextLine();
                history.offer(url);
                System.out.println((url + " added to history." + getTimestamp()));
                showHistory(history);  //updated history
                break;

                case 2:
                if (history.isEmpty()) {
                System.out.println("History is empty. Nothing to delete.");
              } else {
                System.out.println("Current History:");
                for (String site : history) {
                    System.out.println("- " + site);
                }
                System.out.println("Enter the website URL to delete: ");
                String deleteUrl = sc.nextLine();

                if (history.remove(deleteUrl)) {
                     deletedHistory.push(deleteUrl);
                     System.out.println(deleteUrl + " deleted from history" + getTimestamp());
                     showHistory(history);
                } else {
                    System.out.println("Website not found in history.");
                }
              }
              break;

              case 3:
              if (deletedHistory.isEmpty()) {
                System.out.println("No deletion to undo.");
              } else {
                String restored = deletedHistory.pop();
                history.offer(restored);
                System.out.println(restored + " restored to history." + getTimestamp());
                showHistory(history);
              }
              break;

              case 4:
              if (history.isEmpty()) {
                System.out.println("No browsing history found.");
              } else {
                System.out.println("Browser History: ");
                     showHistory(history);
                
              }
              break;

              case 5:
              System.out.println("Exiting Browser History Manager.Goodbye!!");
              sc.close();
              return;

              default: //invalid input
              System.out.println("Invalid option, please try again.");
            }
        }
    }
}