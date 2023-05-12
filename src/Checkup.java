import java.util.ArrayList;

public class Checkup extends CommandBase
{
    public Checkup(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        for(Vehicle x : vehicles)
        {
            if(x.getLicense().equals(tomb[1]))
            {
                x.doCheckup();
            }
        }
    }

    @Override
    public String toString() {
        return "check";
    }
}
