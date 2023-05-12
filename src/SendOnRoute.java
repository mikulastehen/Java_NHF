import java.util.ArrayList;

public class SendOnRoute extends CommandBase
{
    public SendOnRoute(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        //sr <License>
        for(Vehicle x : vehicles)
        {
            if(x.getLicense().equals(tomb[1]))
            {
                x.SendOnDrive();
            }
        }
    }

    @Override
    public String toString() {
        return "sr";
    }
}
