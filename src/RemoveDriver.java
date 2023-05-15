import java.util.ArrayList;

public class RemoveDriver extends CommandBase
{
    public RemoveDriver(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    @Override
    public String toString() {
        return "rd";
    }
}
