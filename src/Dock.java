import java.util.ArrayList;

public class Dock extends CommandBase
{
    public Dock(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        for (Driver x : drivers)
        {
            if(x.getName().equals(tomb[1] + " " + tomb[2]))
            {
                x.DockVehicle();
            }
        }
    }

    @Override
    public String toString() {
        return "dock";
    }
}
