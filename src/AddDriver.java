import java.util.ArrayList;


/**
 * <h1>AddDriver parancsosztály</h1>
 * Ez a class tartalmazza a Driver példányok adatbázisba való felvételéhez szükséges fügvényeket.
 * Az osztály a {@link CommandBase} osztályból származik.
 * @see CommandBase
 * @see Driver
 */
public class AddDriver extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public AddDriver(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A Command metódus hajtja végre a parancsot, a bekért parancs paraméterként van átadva, majd ebből a név extraktálva.
     * A metódus ellenőrzi hogy nincs-e ilyen nevű személy az adatbázisban, amennyiben talál, hibaüzenetet dob vissza.
     * @param args A parancs szöveges formája
     */
    @Override
    public void Command(String args)
    {
        //name = n; driverno = Driver.drivernocount++; licenses = "V";
        //nd <Name>
        String[] tomb = args.split(" ");
        for (Driver x : super.drivers)
        {
            if(x.getName().equals(tomb[1] + " " + tomb[2]))
            {
                System.out.println("HIBA! A megadott név már szerepel a nyilvántartásban!");
                return;
            }
        }
        super.drivers.add(new Driver(tomb[1] + " " + tomb[2]));
        System.out.println("INFO! Új járművezető sikeresen hozzáadva a nyilvántartáshoz!");
    }

    /**
     * <h2>toString metódus</h2>
     * A parancs azonosítására használt metódus
     * @return a parancs betűjele
     */
    @Override
    public String toString() {
        return "nd";
    }
}
