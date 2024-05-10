package controller;

import java.util.Scanner;

public class Validation {
    
    private static final Scanner ip = new Scanner(System.in);
    
    public static String inputString(){
        while(true){
            String result = ip.nextLine();
            if (!result.isEmpty()){
                return result;
            }
            System.out.println("Please enter right format !!!");
        }
    }
    
    public static int inputInt(){
        while(true){
            try {
               int result = Integer.parseInt(ip.nextLine());
               if (result < 0){
                   throw new NumberFormatException();
               }
               return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter number !!!");
            }
            
            
        }
    }
    
    public static int inputLimitInt(int min, int max){
        while(true){
            try {
                int result = Integer.parseInt(ip.nextLine());
            if (result < min || result > max){
                throw new NumberFormatException();
            }
            return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter in range [" + min + ", " + max + "] !!!");
            }
        }
    }
}
