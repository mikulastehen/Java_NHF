import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * <h1>Driver adatosztály</h1>
 * A Driver osztály a két fő adat osztály egyike. Fő szerepe a személyek (vezetők) tárolása, illetve a hozzájuk rendelt jhármű referenciájának tárolása.
 * Az osztály fiedjei lehetővé teszik egy egyedi 2 részű név megadását, illetve egy listát (stringet) amelyben a vezetni jogosító kategóriák vannak.
 * AZ osztály megvalósítja a {@link Serializable} interfészt amelynek segítségével a fájlba mentés serializáció útján valósul meg.
 * @see Vehicle
 */
public class Driver implements Serializable
{
    /**
     * a vezető nevét tárolja.
     * A field egy string, ám a program logikájában (bevitel esetén) mindig 2 részben kezeli <Vezetéknév> <Keresztnév>
     */
    private String name;
    /**
     * egy stringben tárolja a vezető jogosítványait, a program nagy betűs kategóriákat tart számon (B - busz, T - villamos, M - metró)
     */
    private String licenses;
    /**
     * @deprecated A szerializálás miatt ütközések következhetnek be, feladata így nincs, és nem is figyelembe vehető!!
     */
    private static int drivernocount = 1;
    /**
     * @deprecated Eredeti feladata a statikus érték átvétele lett volna
     */
    private int driverno;
    /**
     * Amennyiben a vezetőhöz egy jármű van rendelve, a Driver oldaláról ez a referencia tárolja az adott járművet.
     */
    private Vehicle currentvehicle;

    /**
     * <h2>getName</h2>
     * hagyományos getter metódus
     * @return vezető neve
     */

    public String getName() {
        return name;
    }

    /**
     * <h2>getLicenses</h2>
     * hagyományos getter metódus
     * @return vezető jogosítványlistája
     */
    public String getLicenses() {
        return licenses;
    }

    /**
     * <h2>getCurrentVehicle</h2>
     * Visszaadja a jelenleg hozzárendelt jármű referenciáját
     * @return hozzárendelt jármű objektumának referenciája
     */
    public Vehicle getCurrentvehicle(){return currentvehicle;}

    /**
     * <h2>Konstruktor</h2>
     * A megadott paraméterek alapján egy új Driver objektumot hoz létre.
     * @deprecated A driverno és statikus párja logikája is jelen van, ám ezek nem használatosak
     * @param n név (Vezetéknév Keresztnév)
     */
    public Driver(String n)
    {
        name = n; driverno = Driver.drivernocount++; licenses = "V";
    }

    /**
     * <h2>SetVehicle metódus</h2>
     * A vezető jelenleg hozzárendelt Vehicle objektumának referenciáját állítja be.
     * Logikájában ellenőrzi hogy a Driver-nek nincs-e már aktív járműve, illetve a hozzárendelni kívánt járműnek nincs-e már aktív vezetője.
     * Bármely függőség hamissága esetén ezt hibaüzenettel jelzi a felhasználó felé.
     * A metódus meghívja a {@link Vehicle} osztály setActiveDriver metódusát is, amelynek igaz visszatérése esetén történik meg a hozzárendelés.
     * @param v hozzárendelni kívánt jármű
     */
    public void SetVehicle(Vehicle v)
    {

        if(currentvehicle == null && v.getActivedriver() == null)
        {
            boolean b = v.setActiveDriver(this);
            if(b)
            {
                currentvehicle = v;

                System.out.println("INFO! Jármű sikeresen vezetőhöz rendelve!");
            }

        }
        else System.out.println("HIBA! Az összerendelés sikertelen!");
    }

    /**
     * <h2>DockVehicle metódus</h2>
     * A metódus megszünteti az összerendelést a jármű és a vezető között amennyiben van aktív jármű.
     * A logikája ellenőrzi hogy van e aktív jármű, amennyiben van, annak meghívja a superSet metódusát, majd null értékre állítja a saját referenciáját.
     */
    public void DockVehicle()
    {
        if(currentvehicle != null)
        {
            currentvehicle.SuperSet(null);
            currentvehicle = null;
            System.out.println("INFO! Sikeresen dokkolt jármű!");
            return;
        }
        System.out.println("HIBA! Nincs aktív jármű!");
    }

    /**
     * <h2>SetNewLicense metódus</h2>
     * A metódus a megadott karakterrel bővíti a jogosítványlistát, hozzáadáskor ellenőrzi hogy van e már ilyen a listában a duplikálás elkerülése érdekében.
     * @param l a felvenni kívánt kategória betűjele
     */
    public void SetNewLicense(char l)
    {
        if(!licenses.contains(Character.toString(l)))
        {
            licenses+=l;
            System.out.println("INFO! Sikeresen bővített kategória!");
            return;
        }
        System.out.println("HIBA! Sikertelen kategória felvétel!");
    }

    /**
     * <h2>RemoveLicenses metódus</h2>
     * A metódus segítségével lehet kategóriákat törölni a jogosítvány listából
     * A metódus logikája mindig egy új jogosítványlistát készít az alap V karakterrel, majd ellenőrzi hogy a törölni kívánt benne volt e a régiben, és annak megfelelően hozzáadja a többit.
     * @param l eltávolítani kívánt kategória betűjele
     */
    public void RemoveLicenses(char l)
    {
        String newlicenses = "V";
        if(licenses.contains(Character.toString(l)))
        {
            for(int i = 0; i < licenses.length(); i++)
            {
                if(licenses.charAt(i) != l && licenses.charAt(i) != 'V')
                {
                    newlicenses+=licenses.charAt(i);
                }
            }
            licenses = newlicenses;
            System.out.println("INFO! A kategória törlése sikeres!");
        }
        else System.out.println("HIBA! Ilyen kategória nincs a meglévők közt!");
    }

    /**
     * <h2>toString metódus</h2>
     * Visszatér egy formázott String-el amely a vezető nevét, azonosítóját, jogosítványait és amennyiben van, aktív járművét tartalmazza
     * @return formázott string
     */
    @Override
    public String toString() {
        return String.format("Név: %s, Azonosító: %s, Kategóriák: %s, Aktív jármű: %s", name, driverno, licenses, currentvehicle);
    }



}
