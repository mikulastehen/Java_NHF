import java.util.ArrayList;

public class SetLicense extends CommandBase
{
    public SetLicense(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public void Command(String args)
    {
        String[] tomb = args.split(" ");
        for (Driver x : super.drivers)
        {
            if(x.getName().equals(tomb[1] + " " + tomb[2]))
            {
                x.SetNewLicense(tomb[3].charAt(0));
            }
        }
    }

    @Override
    public String toString() {
        return "sl";
    }
}
