package Controller;

import Model.Brand;
import Model.Car;
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputString(String msg) {
        String str;
        while (true) {
            System.out.println(msg);
            str = sc.nextLine();
            if (str == null || str.length() == 0) {
                System.err.println("It can not empty, try again");
                continue;
            }
            return str;
        }
    }

    public static int inputInt(String msg, int min, int max) {
        while (true) {
            try {
                String num_raw = inputString(msg);
                int num = Integer.parseInt(num_raw);
                if (num < min || num > max) {
                    System.err.println("It must be between from " + min + " to " + max);
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.err.println("It must be a number, try again!!!");
            }
        }
    }

    public static double inputDouble(String msg, double min, double max) {

        while (true) {
            try {
                String num_raw = inputString(msg);
                double num = Double.parseDouble(num_raw);
                if (num < min || num > max) {
                    System.err.println("It must be between from " + min + " to " + max);
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.err.println("It must be a number, try again!!!");
            }
        }
    }

    public boolean checkdubIdCar(ArrayList<Car> list, String id) {
        boolean check = true;
        for (Car a : list) {
            if (a.getCarId().equals(id)) {
                check = false;
            }
        }
        return check;
    }

    public boolean checkdubIdBrands(ArrayList<Brand> list, String id) {
        boolean check = true;
        for (Brand a : list) {
            if (a.getBrandId().equals(id)) {
                check = false;
            }
        }
        return check;
    }

    public boolean checkdubFrameID(ArrayList<Car> list, String id) {
        boolean check = true;
        for (Car a : list) {
            if (a.getFrameId().equals(id)) {
                check = false;
            }
        }
        return check;
    }

    public boolean checkdubEngineID(ArrayList<Car> list, String id) {
        boolean check = true;
        for (Car a : list) {
            if (a.getEngineId().equals(id)) {
                check = false;
            }
        }
        return check;
    }

    public String InputBrandId(String msg, ArrayList<Brand> list) {
        while (true) {
            String BrandId = inputString(msg);
            if (checkdubIdBrands(list, BrandId) == false) {
                System.err.println("it have dublicated, try again");
                continue;
            }
            return BrandId;
        }
    }

    public String InputCarId(String msg, ArrayList<Car> list) {
        while (true) {
            String CarId = inputString(msg);
            if (checkdubIdCar(list, CarId) == false) {
                System.err.println("it have dublicated, try again");
                continue;
            }
            return CarId;
        }
    }

    public String InputFrameID(String msg, ArrayList<Car> list) {
        String regrex = "F\\d{5}";
        while (true) {
            String FrameID = inputString(msg);
            if (!FrameID.matches(regrex)) {
                System.err.println("It must be like this format(F00000)");
                continue;
            }
            if (checkdubFrameID(list, FrameID) == false) {
                System.err.println("it have dublicated, try again");
                continue;
            }
            return FrameID;
        }
    }

    public String InputEngineID(String msg, ArrayList<Car> list) {
        String regrex = "E\\d{5}";
        while (true) {
            String EngineId = inputString(msg);
            if (!EngineId.matches(regrex)) {
                System.err.println("It must be like this format(E00000)");
                continue;
            }
            if (checkdubEngineID(list, EngineId) == false) {
                System.err.println("it have dublicated, try again");
                continue;
            }
            return EngineId;
        }
    }
}
