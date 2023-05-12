import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;

public class Driver implements Serializable
{
    private String name;
    private String licenses;
    private static int drivernocount = 1;
    private int driverno;
    private Vehicle currentvehicle;

    public String getName() {
        return name;
    }

    public String getLicenses() {
        return licenses;
    }
    public Vehicle getCurrentvehicle(){return currentvehicle;}

    public Driver(String n)
    {
        name = n; driverno = Driver.drivernocount++; licenses = "V";
    }
    public void SetVehicle(Vehicle v)
    {

        if(currentvehicle == null && v.getActivedriver() == null)
        {
            boolean b = v.setActiveDriver(this);
            if(b)
            {
                currentvehicle = v;

                System.out.println("INFO! Jármű sikeresen vezetőhöz rendelve!");
            }

        }
        else System.out.println("HIBA! Az összerendelés sikertelen!");
    }

    public void DockVehicle()
    {
        if(currentvehicle != null)
        {
            currentvehicle.SuperSet(null);
            currentvehicle = null;
        }
    }

    public void SetNewLicense(char l)
    {
        if(!licenses.contains(Character.toString(l)))
        {
            licenses+=l;
            System.out.println("INFO! Sikeresen bővített kategória!");
        }
    }
    public void RemoveLicenses(char l)
    {
        String newlicenses = "V";
        if(licenses.contains(Character.toString(l)))
        {
            for(int i = 0; i < licenses.length(); i++)
            {
                if(licenses.charAt(i) != l && licenses.charAt(i) != 'V')
                {
                    newlicenses+=licenses.charAt(i);
                }
            }
            licenses = newlicenses;
            System.out.println("INFO! A kategória törlése sikeres!");
        }
        else System.out.println("HIBA! Ilyen kategória nincs a meglévők közt!");
    }

    @Override
    public String toString() {
        return String.format("Név: %s, Azonosító: %s, Kategóriák: %s, Aktív jármű: %s", name, driverno, licenses, currentvehicle);
    }



}
