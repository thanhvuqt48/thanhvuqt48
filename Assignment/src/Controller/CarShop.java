package Controller;

import Model.Brand;
import Model.Car;
import java.util.Collections;
import java.util.Comparator;

public class CarShop {

    BrandList bl = new BrandList();
    CarList cl = new CarList(bl);
    Validate vl = new Validate();

    public void loadfile() {
        String pathbrand = "./TxtFile/brands.txt";
        if (bl.loadFromFile(pathbrand) == true) {
            System.out.println("Load from file brands.txt successfull!!");

        } else {
            System.err.println("Load faild");
        }
        String pathcar = "./TxtFile/cars.txt";
        if (cl.loadFromFile(pathcar) == true) {
            System.out.println("Load successfull!!!");
        } else {
            System.err.println("Load faild, cars.txt is empty");
        }
    }

    public CarShop() {

    }

    public void printformofBrand(Brand a) {
        System.out.printf("%-1s%-16s%-20s%-15s%-15s\n", "", a.getBrandId(), a.getBrandName(), a.getSoundBrand(), a.getPrice());
    }

    public void ListAllBrands() {
        bl.listBrands();
    }

    public void AddANewBrand() {
        bl.addBrand();

    }

    public void SearchABrandBasedOnTtsID() {
        String IDFind = vl.inputString("Input ID to find");
        int index = bl.searchID(IDFind);
        if (index != (-1)) {
            printformofBrand(bl.get(index));
        } else {
            System.err.println("Can not find Brand base on that ID");
        }
    }

    public void UpdateABrand() {
        bl.updateBrand();
    }

    public void Savebrands() {
        String path = "./TxtFile/brands.txt";
        bl.saveFromFile(path);
    }

    public void Listascending() {
        if (cl.isEmpty()) {
            System.err.println("List is empty");
        }
        Collections.sort(cl, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                String id1 = o1.getBrandId();
                String id2 = o2.getBrandId();
                String name1 = "";
                String name2 = "";
                for (Brand a : bl) {
                    if (a.getBrandId().equals(id1)) {
                        name1 = a.getBrandId();
                    }
                }
                for (Brand a : bl) {
                    if (a.getBrandId().equals(id2)) {
                        name2 = a.getBrandId();
                    }
                }
                return name1.compareTo(name2);
            }

        });
        System.out.println("++++++++++++++LIST OF CAR++++++++++++++");
        System.out.printf("%-1s%-12s%-13s%-10s%-15s%-10s\n", "", "Car ID", "Brand ID", "Color", "Frame ID", "Engine ID");
        for (Car a : cl) {
            cl.printformofCar(a);
        }
    }

    public void Listcarsbasedname() {

        if (cl.isEmpty()) {
            System.err.println("List empty!!");
        }
        cl.printBasedBrandName();

    }

    public void AddCar() {
        cl.addCar();

    }

    public void RemoveCaronID() {
        if (cl.removeCar() == true) {
            System.out.println("Remove sucessfully!!");
        } else {
            System.err.println("Can' remove car with that ID");
        }
    }

    public void updateCar() {
        if (cl.updateCar() == true) {
            System.out.println("Update sucessfull!!");
        } else {
            System.err.println("Can't update with that ID");
        }

    }

    public void saveCar() {
        String path = "./TxtFile/cars.txt";
        if (cl.saveFromFile(path) == true) {
            System.out.println("Save completed!!!");
        } else {
            System.err.println("Save faild, can't find that path");
        }
    }

}
