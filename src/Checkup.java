import java.util.ArrayList;

/**
 * <h1>Checkup parancsosztály</h1>
 * A checkup osztály feladata a Checkup függvény végrehajtása a paraméterként megadott járművön.
 * Az osztály leszármazottja a {@link CommandBase} osztálynak.
 */
public class Checkup extends CommandBase
{
    /**
     * <h2>Konstruktor</h2>
     * @param d Driver lista
     * @param v Vehicle lista
     */
    public Checkup(ArrayList<Driver> d, ArrayList<Vehicle> v) {
        super(d, v);
    }

    /**
     * <h2>Command metódus</h2>
     * A metódus a praméterként megadott járművön végrehajtja a doCheckup() függvényt.
     * A metódus ciklussal keresi meg és azonosítja a keresett járművet
     * @param args A parancs szöveges formában
     */
    @Override
    public void Command(String args) {
        String[] tomb = args.split(" ");
        for(Vehicle x : vehicles)
        {
            if(x.getLicense().equals(tomb[1]))
            {
                x.doCheckup();
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
        return "check";
    }
}
