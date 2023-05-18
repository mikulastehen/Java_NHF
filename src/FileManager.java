import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * <h1>FileManager osztály</h1>
 * Az osztály feladata a szerializáció megvalósításával az adatok fájlba mentése és betöltése az adatszerkezetbe. Az osztály statikus metódusok segítségével teszi ezt, mivel példányosítani felesleges.
 * Az osztály a Driver és Vehicle listákat szerializálja és menti ki egy-egy .ser kiterjesztésű fájlba, illetve abból olvas vissza. A Class File és Object in és output osztályokat hasznosít.
 * @see Driver
 * @see Vehicle
 */
public class FileManager
{
    /**
     * <h2>Save metódus</h2>
     * A metódus átveszi a két menteni kívánt adatszerkezetét, Egy FileOutputStream segítségével előkészíti a fájlt, majd ObjectOutputStream segítségével objektumokként írja őket a fájljaikba.
     * A metódus megpróbál felülírni egy már létező fájlt, amennyiben nem létezik, úgy újat készít.
     * @param d Driver lista
     * @param v Vehicle lista
     */
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

    /**
     * <h2>Load metódus</h2>
     * A metódus a megadott driver.ser és vehicle.ser fájlokból FileInputStream segítségével majd ObjectInputStream használatával beolvassa az adatokat, majd létrehoz két ArrayList-et.
     * Mivel a betöltéskor a Main adatszerkezeteinek kell átadni a betöltött adatokat így a két adatszerkezetet egy két elemű lista tárolja el, majd ez kerül visszaadásra, és ebből lesz kiindexelve a két adatszerkezet.
     * Amennyiben nem sikerül betölteni fájlból mert az nem létezik, úgy új adatszerkezetek kerülnek létrehozásra.
     * @return ArrayList[] amely a két adatsszerkezetet tárolja
     */
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
