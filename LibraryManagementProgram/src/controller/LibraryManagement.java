package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import model.Book;
import view.Menu;

public class LibraryManagement extends Menu{
    
    public List<Book> arr;

    public LibraryManagement(String title, String[] s) {
        super(title, s);
        this.arr = new ArrayList<>();
    }
    
    public void addBook(){
        System.out.println("Enter code: ");
        String code = Validation.inputString();
        System.out.println("Enter book title: ");
        String title = Validation.inputString();
        System.out.println("Enter author: ");
        String author = Validation.inputString();
        System.out.println("Enter year publish: ");
        int yearPublish = Validation.inputInt();
        
        arr.add(new Book(code, title, author, yearPublish));
        System.out.println("Add successfully");     
    }
    
    public void displayAllBook(){
        for (Book book : arr){
            System.out.println(book);
        }
    }
    
    public void searchBook(Predicate<Book> p){
        for (Book book : arr){
            if(p.test(book)){
                System.out.println(book);
            } 
        }
    }
    
//    public void removeBook(String code){
//        for (int i = 0; i < arr.size(); i++){
//            if (arr.get(i).getCode().equals(code)){
//                arr.remove(arr.get(i));
//            }
//        }
//        System.out.println("Delete succesfully");
//    }
     
    public void removeBook(String code){
        arr.removeIf(b -> b.getCode().equals(code));
        System.out.println("Delete succesfully");
    } 

    @Override
    public void execute(int choice) {
        switch (choice) {
                case 1: {
                    addBook();
                    break;
                }
                case 2: {
                    displayAllBook();
                    break;
                }
                case 3: {
                    System.out.println("Enter code to search: ");
                    String code = Validation.inputString();
                    Predicate<Book> p = (Book t) -> t.getCode().equals(code);

                    searchBook(p);
                    break;
                }
                case 4: {
                    System.out.println("Enter code to delete: ");
                    String code = Validation.inputString();
                    removeBook(code);
                    break;
                }
                case 5: {
                    System.out.println("Exit !!!");
                    break;
                }
            }
    }
}
