import java.util.ArrayList;

public class RemoveLicense extends CommandBase
{
    public RemoveLicense(ArrayList<Driver> d, ArrayList<Vehicle> v) {
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
                x.RemoveLicenses(tomb[3].charAt(0));
            }
        }
    }

    @Override
    public String toString() {
        return "rl";
    }
}
