import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        ArrayList[] load = FileManager.Load();
        ArrayList<Driver> vezetok = load[0];
        ArrayList<Vehicle> jarmuvek = load[1];

        ArrayList<CommandBase> commands = new ArrayList<>();
        commands.add(new AddVehicle(vezetok, jarmuvek));
        commands.add(new AddDriver(vezetok, jarmuvek));
        commands.add(new SetLicense(vezetok, jarmuvek));

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            String be = sc.nextLine();
            for(CommandBase x : commands)
            {
                if(x.toString().equals(be.split(" ")[0]))
                {
                    x.Command(be);
                }
            }
        }
        //FileManager.Save(vezetok, jarmuvek);*/

        //System.out.println();
    }
}