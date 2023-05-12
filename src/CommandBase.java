import java.util.ArrayList;

public class CommandBase
{
    ArrayList<Driver> drivers;
    ArrayList<Vehicle> vehicles;
    public CommandBase(ArrayList<Driver> d, ArrayList<Vehicle> v)
    {
        drivers = d;vehicles = v;
    }

    public void Command(String args) {}

    @Override
    public String toString() {
        return "CommandBase";}
}
