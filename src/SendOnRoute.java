import java.util.ArrayList;

/**
 * <h1>SendOnRoute parancsosztály</h1>
 * Az osztály feladata a parancs alapján az adott jármű kiküldése forgalomba
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Vehicle
 */
public class SendOnRoute extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * A konstruktor szabványos módon vbeszi át az adatbázist
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public SendOnRoute(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A metódus végrehajtja a parancsot, a megadott rendszámot felhasználva.
     * A logika kikeresi a megfelelő rendszámot, majd kiadja a megfelelő járműnek a SendOnDriver metódust.
     * @param args parancs szöveges formában
     */
    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        //sr <License>
        for(Vehicle x : vehicles)
        {
            if(x.getLicense().equals(tomb[1]))
            {
                x.SendOnDrive();
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
        return "sr";
    }
}
