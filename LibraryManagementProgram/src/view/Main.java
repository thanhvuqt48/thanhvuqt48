package view;

import controller.LibraryManagement;

public class Main {

    public static void main(String[] args) {
        String title = "--- Library Management System ---";
        String[] s = {
            "Add book",
            "Display all book",
            "Search book",
            "Remove book",
            "Exit"      
        };
               
        Menu menu = new LibraryManagement(title, s);
        menu.run();
    }
}
