import java.util.ArrayList;

/**
 * <h1>ListVehicleData parancsolsztály</h1>
 * Az osztály feladata a járművek listázó parancsának megvalósítása.
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Vehicle
 */
public class ListVehicleData extends CommandBase
{

    /**
     * <h2>Konstruktor</h2>
     * A konstruktor szabványos módón veszi át az adatbázist.
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public ListVehicleData(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A metódus cégrehajtja a listázási műveletet. A logika szerint a ciklus végigfut az összes járműven majd a toString metódusát meghívva formázott alakban visszakapja az adatait.
     * @param args parancs szöveges formában
     */
    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        System.out.println("Gyártó: Model: Rendszám/Pályaszám: Jelenlegi vezető: Szolgálatban:");
        for (Vehicle x : vehicles)
        {
            System.out.println(x.toString() + " " + x.getActivedriver() + " " + x.getOnroute());
        }
    }

    /**
     * <h2>toString metódus</h2>
     * A parancs azonosítására használt metódus
     * @return a parancs betűjele
     */
    @Override
    public String toString() {
        return "lsv";
    }
}
