import java.util.ArrayList;

public class AddDriver extends CommandBase
{
    public AddDriver(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public void Command(String args)
    {
        //name = n; driverno = Driver.drivernocount++; licenses = "V";
        //nd <Name>
        String[] tomb = args.split(" ");
        for (Driver x : super.drivers)
        {
            if(x.getName().equals(tomb[1]))
            {
                System.out.println("HIBA! A megadott név már szerepel a nyilvántartásban!");
                return;
            }
        }
        super.drivers.add(new Driver(tomb[1] + " " + tomb[2]));
        System.out.println("INFO! Új járművezető sikeresen hozzáadva a nyilvántartáshoz!");
    }

    @Override
    public String toString() {
        return "nd";
    }
}
