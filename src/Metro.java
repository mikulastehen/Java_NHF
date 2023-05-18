/**
 * <h1>Metro járműosztály</h1>
 * Az osztály a Metro járművek osztálya, egyéni fieldekkel, illetve a jármű kategóriát azonosító függvénnyel.
 * Az osztály a {@link Vehicle} osztályból öröklődik.
 * @see Vehicle
 */
public class Metro extends Vehicle
{
    /**
     * funkciós haszna nincs
     */
    private final String avr;
    /**
     * funkciós haszna nincs
     */
    private final boolean avron;
    /**
     * funkciós haszna nincs
     */
    private final int wagno;

    /**
     * <h2>getType</h2>
     * Hagyományos getter metódus, visszaadja a típusát a járműnek
     * @return a jármű típusa
     */
    public String getType() {return "M";}

    /**
     * <h2>Konstruktor</h2>
     * Szabványosan átveszi a paramétereket és elkészíti az új példányt.
     * @param ma Gyártó
     * @param mo Model
     * @param avr AVR típusa
     * @param wgn Kocsiszám
     * @param m Üzemi tömeg
     * @param d Ajtók száma
     * @param l pályaszám
     */
    public Metro(String ma, String mo, String avr, int wgn, int m, int d, String l)
    {
        super(m, d, ma, mo, l);
        this.avr = avr; avron = false; wagno = wgn;
    }

    /**
     * <h2>setActiveDriver metódus</h2>
     * A metódus egy "proxy" mivel mikor egy Driverhez be kell állítani egy járművet, a heterogén objektumkezelés miatt nem lehet kikérni a Vehicle kategóriájját, ezt csaka tényleges példányból lehet.
     * A program ezért lefuttatja a setActiveDriver metódust ami ellenőrzi hogy a Driver rendelkezik e az adott típus kategóriájával, majd ez alapján egy bool értéket visszaad, és a Vehicle superSet metódusát meghívja.
     * @param d Driver objektum
     * @return igaz/hamis annak függvényében hogy az átadott vezetőnek van e jogosultsága ezt a kategóriát vezetni
     */
    @Override
    public boolean setActiveDriver(Driver d) {
        if(d.getLicenses().contains("M"))
        {
            SuperSet(d);
            return true;
        }
        System.out.println("HIBA! A járművezetőnek nincs jogosultsága a megadott járműkategóriára!");
        return false;
    }

}
