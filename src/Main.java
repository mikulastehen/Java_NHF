import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Vehicle> jarmuvek = new ArrayList<>();
        ArrayList<Driver> vezetok = new ArrayList<>();

        jarmuvek.add(new Bus(1500, 3, "Mercedes", "G2", "FLR-254", "Diesel", true));
        vezetok.add(new Driver("Joska"));
        vezetok.add(new Driver("Pista"));

        vezetok.get(0).SetNewLicense('B');
        vezetok.get(0).SetVehicle(jarmuvek.get(0));
        jarmuvek.get(0).SendOnDrive();
    }
}