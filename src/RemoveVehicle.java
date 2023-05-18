import java.util.ArrayList;

/**
 * <h1>RemoveVehicle parancsosztály</h1>
 * Az osztály feladata a parancs alapján megadott jármű törlése az adatbázisból.
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Vehicle
 */
public class RemoveVehicle extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * A konstruktor szabványos módon átveszi az adatbázist
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public RemoveVehicle(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A metódus a vezetőéhez hasonló módon működik, csak itt Vehicle típussal és nem az aktív járművet hanem az aktív vezetőt kérdezi le
     * @param args parancs szöveges formában
     * @see RemoveDriver
     */
    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        if(super.vehicles.removeIf(x -> x.getLicense().equals(tomb[1]) && x.getActivedriver() == null))
        {
            System.out.println("A  törlése sikeres");
            return;
        }
        System.out.println("A jármű törlése sikertelen!");
    }

    /**
     * <h2>toString metódus</h2>
     * A parancs azonosítására használt metódus
     * @return a parancs betűjele
     */
    @Override
    public String toString() {
        return "rv";
    }
}
