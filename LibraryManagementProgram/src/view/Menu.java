package view;

import controller.Validation;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Menu {

    protected String title;
    protected ArrayList<String> list = new ArrayList<>();

    public Menu(String title, String[] s) {
        this.title = title;
        list.addAll(Arrays.asList(s));
    }
    
    public void display(){
        System.out.println(title);
        for (int i = 0; i < list.size(); i++){
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
    
    public int getChoice(){
        System.out.println("Enter your selection: ");
        int choice = Validation.inputInt();
        return choice;   
    }
    
    public abstract void execute(int choice);
    
    public void run(){
        int choice;
        do{
            display();
            choice = getChoice();
            execute(choice);
        } while (choice > 0 && choice < list.size());
    }

}
