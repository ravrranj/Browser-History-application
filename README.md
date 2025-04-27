# Browser-History-application
Project: Simulate Deleting Browser History Using Data Structures


Key Concepts:
Queue (FIFO):

The browser history can be managed using a queue since the history is processed in a First-In-First-Out (FIFO) manner.

We can use a queue to represent the browser's visited websites.

Stack (For Undoing Deletion):

Use a stack to simulate an undo operation in case the user wants to restore the deleted history.

Linked List (Optional):

You can implement a doubly linked list if you want to allow for more complex operations like adding/deleting from both ends (for more advanced functionality).

Other Operations:

You can have operations like viewing history, adding new pages, deleting pages, and even an undo feature using a stack.


Explanation of Methods:
addWebsite:

Adds a website to the history queue.

deleteWebsite:

Deletes the most recent website from the history (using poll to remove from the front of the queue) and stores it in the stack for possible undo.

undoDelete:

Restores the most recently deleted website by popping from the stack and adding it back to the queue.

viewHistory:

Prints the current history in the queue.

Menu System:
The program now shows a menu where you can choose actions like:

Add a website to the history.

Delete the most recent website from the history.

Undo the last deletion.

View the current browser history.

Exit the program.

User Input Handling:
The user is prompted to enter inputs based on the action they choose, making it interactive.
