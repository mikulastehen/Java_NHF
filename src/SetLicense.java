import java.util.ArrayList;


/**
 * <h1>SetLicense parancsosztály</h1>
 * Az osztály feladata az új kategóriák hozzáadása a vezetők jogosítványlistájához a megadott paraméterek alapján.
 * Az osztály a {@link CommandBase} osztályból öröklődik
 * @see Driver
 */
public class SetLicense extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * Szabványos módon átveszi az adatbázist
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public SetLicense(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A metódus a megadott paraméter alapján kikeresi a vezető listából az adott vezetőt és végrehajtja rajta a SetLicense metódust.
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
                x.SetNewLicense(tomb[3].charAt(0));
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
        return "sl";
    }
}
