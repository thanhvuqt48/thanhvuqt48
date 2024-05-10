package Controller;

import Model.Brand;
import View.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BrandList extends ArrayList<Brand> {

    Validate vl = new Validate();

    public BrandList() {
    }

    public void printformofBrand(Brand a) {
        System.out.printf("%-1s%-16s%-35s%-20s%-15s\n", "", a.getBrandId(), a.getBrandName(), a.getSoundBrand(), a.getPrice());
    }

    public boolean loadFromFile(String path) {
        boolean check = true;
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] a = line.split(",");
                String brandID = a[0].trim();
                String brandName = a[1].trim();
                String[] sound = a[2].split(":");
                String soundBrand = sound[0].trim();
                double price = Double.parseDouble(sound[1]);
                Brand b = new Brand(brandID, brandName, soundBrand, price);
                this.add(b);
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

            for (Brand a : this) {
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
        int index = 0;
        boolean check = false;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandId().equals(ID)) {
                index = i;
                check = true;
            }
        }
        if (check == false) {
            index = -1;
        }
        return index;
    }

    public Brand getUserChoice() {
        Menu mn = new Menu();
        Brand brandChoose = mn.ref_getChoice(this);
        return brandChoose;
    }

    public void addBrand() {
        String id = vl.InputBrandId("Input brand ID", this);
        String name = vl.inputString("Input brand name: ");
        String soundBrand = vl.inputString("Input sound Brand");
        double price = vl.inputDouble("input price", 0, Double.MAX_VALUE);
        Brand a = new Brand(id, name, soundBrand, price);
        this.add(a);

    }

    public void updateBrand() {
        String idFind = vl.inputString("Inpput ID of Brand you want to find:");
        for (Brand a : this) {
            if (a.getBrandId().equals(idFind)) {
                String newname = vl.inputString("Input new name: ");
                String soundbrand = vl.inputString("Input new sound brand: ");
                double newprice = vl.inputDouble("input price", 0, Double.MAX_VALUE);
                a.setBrandName(newname);
                a.setSoundBrand(soundbrand);
                a.setPrice(newprice);
            }
        }
    }

    public void listBrands() {
        if (this.isEmpty()) {
            System.err.println("It have empty!!");
        } else {
            System.out.println("++++++++++++++LIST OF BRAND++++++++++++++");
            System.out.printf("%-1s%-16s%-35s%-20s%-15s\n", "", "Brand ID", "Brand Name", "Sound Brand", "Prices");
            for (Brand a : this) {
                printformofBrand(a);
            }
        }
    }
}
