import java.util.ArrayList;

/**
 * <h1>RemoveDriver parancsosztály</h1>
 * Az osztály feladata a RemoveDriver parancs feldolgozása és vágrehajtása.
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Driver
 */
public class RemoveDriver extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * Szabványos módon átveszi az adatbázist
     * @param d Driver lista
     * @param v Jármű lista
     */
    public RemoveDriver(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A metódus átveszi a kapott parancsot, majd lambdafüggvény segítségével meghatározza hogy van e megadott név a nyilvántartásban és van e jelenleg járműve.
     * A feltételek igazsága esetén megtörténik a törlés, amiről értesítést kap a felhasználó.
     * @param args parancs szöveges formában
     */
    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        if(super.drivers.removeIf(x -> x.getName().equals(tomb[1] + " " + tomb[2]) && x.getCurrentvehicle() == null))
        {
            System.out.println("A  törlése sikeres");
            return;
        }
        System.out.println("A vezető törlése sikertelen!");

    }

    /**
     * <h2>toString metódus</h2>
     * A parancs azonosítására használt metódus
     * @return a parancs betűjele
     */
    @Override
    public String toString() {
        return "rd";
    }
}
