import java.util.ArrayList;


/**
 * <h1>SetVehicle parancsosztály</h1>
 * Az osztály feladata a jármű hozzárendelése egy vezetőhöz az adott parancs alapján.
 * Az osztály a {@link CommandBase} osztályból öröklődik.
 * @see Vehicle
 * @see Driver
 */
public class SetVehicle extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * Szabványos módon átveszi az adatbázist
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public SetVehicle(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A megadott parancs alapján kikeresi a vezetőt és hozzá a megfelelő járművet, majd lefuttatja a Driver objektumon a SetVehicle metódust.
     * @param args parancs szöveges formában
     */
    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        //sv <Drivername> <License>
        for(Driver x : drivers)
        {
            if(x.getName().equals(tomb[1] + " " + tomb[2]))
            {
                for(Vehicle y : vehicles)
                {
                    if(y.getLicense().equals(tomb[3]))
                    {
                        x.SetVehicle(y);
                    }
                }
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
        return "sv";
    }
}
