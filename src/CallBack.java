import java.util.ArrayList;


/**
 * <h1>CallBack parancsosztály</h1>
 * Az osztály feladata a paraméterként meghatározott jármű visszahívása a forgalomból.
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Vehicle
 * @see Driver
 */
public class CallBack extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public CallBack(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A command metódus végrehajtja a parancsot, miszerint a megadott járművet visszahívjuk a szolgálatból.
     * A ciklus végigmegy az összes járműven, a keresett járművön végrehajtja a CallBack() függvényt
     * @param args A parancs szöveges formája
     */
    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        for(Vehicle x : vehicles)
        {
            if(x.getLicense().equals(tomb[1]))
            {
                x.CallBack();
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
        return "cb";
    }
}
