import java.util.ArrayList;

public class SetVehicle extends CommandBase
{
    public SetVehicle(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        //sv <Drivername> <License>
        for(Driver x : drivers)
        {
            if(x.getName().equals(tomb[1] + " " + tomb[2]))
            {
                for(Vehicle y : vehicles)
                {
                    if(y.getLicense().equals(tomb[3]))
                    {
                        x.SetVehicle(y);
                    }
                }
            }
        }

    }

    @Override
    public String toString() {
        return "sv";
    }
}
