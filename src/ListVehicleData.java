import java.util.ArrayList;

public class ListVehicleData extends CommandBase
{
    public ListVehicleData(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        System.out.println("Gyártó: Model: Rendszám/Pályaszám: Üzemi tömeg: Ajtók száma: Utolsó ellenőrzés: Szolgálatban:");
        for (Vehicle x : vehicles)
        {
            System.out.printf(x.toString());
        }
    }

    @Override
    public String toString() {
        return "lsv";
    }
}
