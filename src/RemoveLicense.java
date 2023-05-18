import java.util.ArrayList;

/**
 * <h1>RemoveLicense parancsosztály</h1>
 * Az osztály feladata a jogosítvány típusok törlésének kezelése a megadott parancs alapján.
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Driver
 */
public class RemoveLicense extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * A konstruktor szabványosan veszi át az adatbázist.
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public RemoveLicense(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A metódus a kapott parancs alapján elvégzi a jogosítvány kategória törlését.
     * A logikája kikeresi az adott nevű Driver-t majd futtatja rajta a RemoveLicense metódust. Mivel a metódus csak egy karaktert vesz át, így a tömb indexelésnél szükség van a charAt metódusra is.
     * @param args parancs szöveges formában
     */
    @Override
    public void Command(String args)
    {
        String[] tomb = args.split(" ");
        for (Driver x : super.drivers)
        {
            if(x.getName().equals(tomb[1] + " " + tomb[2]))
            {
                x.RemoveLicenses(tomb[3].charAt(0));
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
        return "rl";
    }
}
