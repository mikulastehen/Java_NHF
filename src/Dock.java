import java.util.ArrayList;

/**
 * <h1>Dock parancsosztály</h1>
 * A Dock osztály a járművek dock() függvényét megvalosító parancsosztálya.
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Vehicle
 * @see Driver
 */
public class Dock extends CommandBase
{

    /**
     * <h2>Konstruktor</h2>
     * Átveszi a szabványos formában az adatbázist.
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public Dock(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * Átveszi a szöveges formátumú parancsot, majd ciklussal kikeresi a megadott járművet és végrehajtja a parancsot.
     * @param args Parancs szöveges formában
     */
    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        for (Driver x : drivers)
        {
            if(x.getName().equals(tomb[1] + " " + tomb[2]))
            {
                x.DockVehicle();
            }
        }
    }

    /**
     * <h2>toString metódus</h2>
     * A parancs azonosítására használt metódus
     * @return a parancs betűjele
     */
    @Override
    public String toString() {
        return "dock";
    }
}
