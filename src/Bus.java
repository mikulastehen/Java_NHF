import java.io.Serializable;


/**
 * <h1>Bus járműosztály</h1>
 * Ez a class tartalmazza a Bus példányok létrehozásához szükséges konstruktort, fieldeket, és függvényeket.
 * Ez az osztály a {@link Vehicle} leszármazottja.
 * Az osztály implementálja a {@link Serializable} interfészt a fájlba írás végett.
 * @see Vehicle
 * @see Driver
 */
public class Bus extends Vehicle implements Serializable
{
    /**
     * A fuel field egy String, funkcionális feladata nincs.
     */
    private final String fuel;

    /**
     * Az access field egy boolean, funkcionális feladata nincs.
     */
    private final boolean access;

    /**
     * <h2>Konstruktor</h2>
     * A Bus osztály konstruktora az ősosztály konstruktorát, és saját egyéni fildjeit tölti fel a megadott paraméterek alapján.
     * @param ma Busz gyártója
     * @param mo Busz modellje
     * @param f Busz üzemanyagtípusa
     * @param a Busz akadálymentessége
     * @param m Busz üzemi tömege
     * @param d Busz ajtóinak száma
     * @param l Busz rendszáma
     */
    public Bus(String ma, String mo, String f, boolean a, int m, int d, String l)
    {
        super(m, d, ma, mo, l);
        fuel = f; access = a;
    }

    /**
     * <h2>setActiveDriver metódus</h2>
     * A metódus legfőbb feladata a jármű vezetőjének kategóriájának visszaellenőrzése. Mivel az ősosztály nem tudja ellenőrizni a példányok típusát, így szükségessé válik ez a fajta megvalósítás.
     * A metódus ellenőrzi a paraméterként megadott vezető kategóriajogosultságait, és ellenőrzi a saját típusára.
     * @param d Driver objektum
     * @return igaz/hamis annak függvényében hogy a vezető rendelkezik a megfelelő kategóriával
     * @see Metro
     */
    @Override
    public boolean setActiveDriver(Driver d)
    {
        if(d.getLicenses().contains("B"))
        {
            SuperSet(d);
            return true;
        }
        System.out.println("HIBA! A járművezetőnek nincs jogosultsága a megadott járműkategóriára!");
        return false;
    }

}
