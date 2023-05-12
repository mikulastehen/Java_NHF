import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class FileManager
{
    public static void Save(ArrayList<Driver> d, ArrayList<Vehicle> v)
    {
        /*Hashtable<Driver, Vehicle> connections = new Hashtable<>();
        for(Driver x : d)
        {
            if(x.getCurrentvehicle() != null)
            {
                connections.put(x, x.getCurrentvehicle());
                x.DockVehicle();
            }
        }*/


        try {
            FileOutputStream driverfile = new FileOutputStream("drivers.ser");
            FileOutputStream vehiclefile = new FileOutputStream("vehicles.ser");
            ObjectOutputStream driverobj = new ObjectOutputStream(driverfile);
            ObjectOutputStream vehicleobj = new ObjectOutputStream(vehiclefile);
            driverobj.writeObject(d);
            vehicleobj.writeObject(v);
            driverobj.close();
            driverfile.close();
            vehiclefile.close();
            vehicleobj.close();
            System.out.println("INFO! Mentés sikeres");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList[] Load()
    {
        try
        {
            FileInputStream driverfile = new FileInputStream("drivers.ser");
            FileInputStream vehiclefile = new FileInputStream("vehicles.ser");
            ObjectInputStream driverobj = new ObjectInputStream(driverfile);
            ObjectInputStream vehicleobj = new ObjectInputStream(vehiclefile);
            ArrayList<Driver> drivers = (ArrayList<Driver>) driverobj.readObject();
            ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) vehicleobj.readObject();
            return new ArrayList[]{drivers, vehicles};
        }
        catch (IOException | ClassNotFoundException e )
        {
            System.out.println("HIBA! A betöltés sikertelen, új listák létrehozva!");
        }
        return new ArrayList[]{new ArrayList<Driver>(), new ArrayList<Vehicle>()};
    }
}
