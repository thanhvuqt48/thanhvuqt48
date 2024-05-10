package View;

import Controller.Validate;
import Model.Brand;
import java.util.ArrayList;

public class Menu extends ArrayList<String> {

    Validate vl = new Validate();

    public int int_getChoice(ArrayList<Brand> listBrand) {
        int choice = 0;
        for (int i = 0; i < listBrand.size(); i++) {
            System.out.println((1 + i) + "/ " + listBrand.get(i).toString());
        }

        choice = vl.inputInt("Please choose an option", 1, listBrand.size());
        return choice;

    }

    public Menu() {
    }

    public Brand ref_getChoice(ArrayList<Brand> listBrand) {
        int index = int_getChoice(listBrand);
        return listBrand.get(index - 1);
    }

}
