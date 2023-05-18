/**
 * <h1>Tram járműosztály</h1>
 * Az osztály tartalmazza az egyéni mezőket a Tram objektumhoz illetve az azonosító függvényét.
 * Az osztály a {@link Vehicle} osztályból öröklődik.
 */
public class Tram extends Vehicle
{
    /**
     * funkciós haszna nincs
     */
    private String pantograph;
    /**
     * funkciós haszna nincs
     */
    private boolean hasac;
    /**
     * funkciós haszna nincs
     */
    private String ctlogic;

    /**
     * <h2>getType</h2>
     * hagyományos getter metódus
     * @return a jármű tipusjele
     */

    public String getType() {return "T";}

    /**
     * <h2>Kostruktor</h2>
     * A megadott paramétereket szabványos módon átadja az új objektumnak
     * @param ma Gyártó
     * @param mo Model
     * @param pt Áramszedő kivitel
     * @param ct Vezérlési kivitel
     * @param ac klíma (igaz/hamis)
     * @param m Üzemi tömeg
     * @param d Ajtók száma
     * @param l pályaszám
     */
    public Tram(String ma, String mo, String pt, String ct, boolean ac, int m, int d, String l)
    {
        super(m, d, ma, mo, l);
        pantograph = pt; hasac = ac; ctlogic = ct;
    }

    /**
     * <h2>SetActiveDriver</h2>
     * A metódus feladata a hozzárendelési folyamat közben a vezető kategória meglétének ellenőrzése. Amennyiben rendelkezik a szükséges kategóriával, úgy meghívja az ősosztályának a superSet metódusát.
     * @param d Driver objektum
     * @return igaz/hamis annak függvényében hogy a vezető rendelkezik a megfelelő kategóriával
     * @see Metro
     */
    @Override
    public boolean setActiveDriver(Driver d)
    {
        if(d.getLicenses().contains("T"))
        {
            SuperSet(d);
            return true;
        }
        System.out.println("HIBA! A járművezetőnek nincs jogosultsága a megadott járműkategóriára!");
        return false;
    }
}
