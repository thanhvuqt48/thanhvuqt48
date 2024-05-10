package Controller;

import Model.Brand;
import Model.Car;
import View.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author trinhdinhngocan
 */
public class CarList extends ArrayList<Car> {

    BrandList brandList = new BrandList();
    Validate vl = new Validate();
    Menu mn = new Menu();

    public CarList() {
    }

    public CarList(BrandList bList) {
        brandList = bList;
    }

    public boolean loadFromFile(String path) {
        boolean check = true;
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer stn = new StringTokenizer(line, ",");
                String carId = stn.nextToken().trim();
                String BrandID = stn.nextToken().trim();
                String color = stn.nextToken().trim();
                String frameID = stn.nextToken().trim();
                String engineID = stn.nextToken().trim();
                Car a = new Car(carId, BrandID, color, frameID, engineID);
                this.add(a);
            }
            br.close();
            isr.close();
            fis.close();

        } catch (IOException e) {
            check = false;
        }
        return check;
    }

    public boolean saveFromFile(String path) {
        boolean check = true;
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            for (Car a : this) {
                bw.write(a.toString());
                bw.write("\n");
            }
            bw.close();
            osw.close();
            fos.close();

        } catch (IOException e) {
            check = false;
        }
        return check;
    }

    public int searchID(String ID) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarId().equals(ID)) {
                index = i;
            }
        }
        return index;
    }

    public int searchFrame(String fID) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameId().equals(fID)) {
                index = i;
            }
        }
        return index;
    }

    public int searchEngine(String eID) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineId().equals(eID)) {
                index = i;
            }
        }
        return index;
    }

    public void addCar() {
        String carID = vl.InputCarId("input car id: ", this);
        System.out.println("++Choose your car brand++");
        Brand a = mn.ref_getChoice(brandList);
        String brandID = a.getBrandId();
        String color = vl.inputString("Input color: ");
        String frameID = vl.InputFrameID("Input frame ID ", this);
        String engineID = vl.InputEngineID("Input egine ID", this);
        Car b = new Car(carID, brandID, color, frameID, engineID);
        this.add(b);
    }

    public void printformofCar(Car a) {
        System.out.printf("%-1s%-12s%-13s%-10s%-15s%-10s\n", "", a.getCarId(), a.getBrandId(), a.getColor(), a.getFrameId(), a.getEngineId());
    }

    public void printBasedBrandName() {
        String nameFind = vl.inputString("Input a part of name brand: ").toLowerCase();
        String idFind = "";
        boolean check = false;
        for (Brand b : brandList) {
            if (b.getBrandName().toLowerCase().contains(nameFind)) {
                check = true;
                idFind = b.getBrandId();
                for (Car a : this) {
                    if (a.getBrandId().equals(idFind)) {
                        printformofCar(a);
                    }
                }
            }
        }
        if (check == false) {
            System.err.println("Can't not find with this name!!");
        }
    }

    public boolean removeCar() {
        int index = 0;
        boolean check = false;
        String idFind = vl.inputString("Input ID of car you want to delete");
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarId().equals(idFind)) {
                index = i;
                check = true;
            }
        }
        if (check == true) {
            this.remove(index);
            return true;
        }
        return false;

    }

    public boolean updateCar() {
        int index = 0;
        boolean check = false;
        String idFind = vl.inputString("Input ID of car you want to update");
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarId().equals(idFind)) {
                index = i;
                check = true;
            }
        }
        if (check == true) {

            Brand a = mn.ref_getChoice(brandList);
            String brandID = a.getBrandId();
            String color = vl.inputString("Input color: ");
            String frameID = vl.InputFrameID("Input frame ID ", this);
            String engineID = vl.InputEngineID("Input egine ID", this);

            this.get(index).setBrandId(brandID);
            this.get(index).setColor(color);
            this.get(index).setFrameId(frameID);
            this.get(index).setEngineId(engineID);

        }
        return check;
    }

    public void listCars() {
        System.out.printf("%-1s%-12s%-13s%-10s%-15s%-10s\n", "", "Car ID", "Brand ID", "Color", "Frame ID", "Engine ID");
        for (Car a : this) {
            printformofCar(a);
        }
    }

}
