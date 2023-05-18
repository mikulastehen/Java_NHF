import java.io.Serializable;

/**
 * <h1>Vehicle osztály</h1>
 * Ez az osztály minden járműtípus ősosztálya, az osztályban megtalálhatóak a főbb mezők, illetve függvények amelyek a járművek generikus viselkedését határozzák meg.
 * Az osztály megvalósítja a Serializable iterfészt annak érdekében hogy a járműveket tartalmazó lista menthető legyen.
 */
public abstract class Vehicle implements Serializable
{
    /**
     * üzemi tömeg
     */
    private final int mass;
    /**
     * ajtók száma
     */
    private final int doorcount;
    /**
     * Kötelező ellenőrzés elvégzéséig megtehető szolgálatok. Ez most hard coded a redszerben (5 szolgálat)
     */
    private final int checkreq;
    /**
     * Gyártó
     */
    private final String make;
    /**
     * Model
     */
    private final String model;
    /**
     * A járműhöz rendelt Driver objektum referenciája
     */
    private Driver activedriver;
    /**
     * Az utolsó ellenőrzés óta eltelt szolgálatok száma
     */
    private int lastcheck;
    /**
     * A jármű pályaszáma/rendszáma
     */
    private final String license;
    /**
     * bool érték, azt tárolja hogy a jármű épp forgalomban van-e
     */
    private boolean onroute;


    /**
     * <h2>getOnroute metódus</h2>
     * hagyományos getter metódus
     * @return igaz/hamis érték
     */
    public boolean getOnroute() {return onroute;}

    /**
     * <h2>getActiveDriver</h2>
     * A metódus visszaadja a jelenlegi hozzárendelt vezető referenciáját
     * @return Driver objektum referenciája, vagy null
     */
    public Driver getActivedriver() {
        return activedriver;
    }

    /**
     * <h2>getLicenses metódus</h2>
     * visszaadja a jogosítvány listát
     * @return licenses mező
     */
    public String getLicense() {
        return license;
    }

    /**
     * <h2>getLastCheck metódus</h2>
     * visszaadja az utolsó ellenőrzés óta eltelt szolgálatok számát
     * @return szolgálatok száma
     */
    public int getLastcheck() {return lastcheck;}

    /**
     * <h2>SetActiveDriver metódus</h2>
     * Ez a metódus absztrakt, minden alosztály maga valósítja meg, ez a metódus ellenőrzi egy szolgálatba küldés előtt hogy az adott vezetőnek van e jogosultsága vezetni az adott járművet.
     * @param d Driver objektum
     * @return igaz/hamis érték a vezető kategóriájának megfelelően
     */
    public abstract boolean setActiveDriver(Driver d);

    /**
     * <h2>SuperSet metódus</h2>
     * Amennyiben a setActiveDriver metódus igazzal tér vissza, úgy a végleges összerendelést ez a metódus teszi meg, már ellenőrzések nélkül.
     * @param d Driver objektum
     */
    public void SuperSet(Driver d)
    {
        activedriver = d;
    }

    /**
     * <h2>toString metódus</h2>
     * A metódus formázott alakban kiírja az adott jármű gyártmányát, modeljét és rendszámát/pályaszámát
     * @return formázott string
     */
    @Override
    public String toString() {
        return make + " " + model + " " + license;
    }

    /**
     * <h2>Konstruktor</h2>
     * A megadott paraméterek alapján elkészíti a példányt. a checkreq értéke statikusan 5, míg a szolgálatok száma 0-n indul.
     * @param m Üzemi tömeg
     * @param d Ajtók száma
     * @param ma Gyártó
     * @param mo Model
     * @param l Rendszám/pályaszám
     */
    public Vehicle(int m, int d, String ma, String mo, String l)
    {
        mass = m;
        doorcount = d; make = ma; model = mo; license = l;
        checkreq = 5; lastcheck = 0;
    }

    /**
     * <h2>SendOnDrive metódus</h2>
     * A metódus ellenőrzi hogy a jármű hozzá van e rendelve vezetőhöz, illetve hogy a szolgálatai szááma még nem érték el a kötelező ellenőrzés mennyiségét, és amennyiben nem, úgy kiküldi forgalomba.
     * Hiba esetén azt jelzi a felhasználónak.
     */
    public void SendOnDrive()
    {
        if(activedriver != null && checkreq > lastcheck)
        {
            onroute = true;
            System.out.println("INFO! A jármű sikeresen kiküldve forgalomba!");
        }
        else if(checkreq <= lastcheck)
        {
            System.out.println("HIBA! A jármű kötelező ellenőrzése aktuális");
        }
        else System.out.println("HIBA! Nincs járművezető a járműhöz rendelve!");
    }

    /**
     * <h2>Callback metódus</h2>
     * A metódus a forgalomban lévő járművet visszahívja, majd megnöveli az ellenőrzés óta eltelt szolgálatok számát.
     */
    public void CallBack()
    {
        if(onroute)
        {
            System.out.println("INFO! A jármű sikeresen visszahívva a szolgálatból!");
            onroute = false;
            lastcheck++;
        }
        else System.out.println("HIBA! A jármű nincs forgalomban!");
    }

    /**
     * <h2>doCheckup metódus</h2>
     * A metódus elvégzi a kötelező ellenőrzést, az ellenőrzés óta eltelt szolgálatok számát lenullázza.
     * A feladat csak akkor végrehajtható ha valakihez hozzá van rendelve a jármű, ileltve ha az nincs forgalomban.
     */
    public void doCheckup()
    {
        if(!onroute && activedriver != null)
        {
            lastcheck = 0;
            System.out.println("INFO! A jármű műszaki ellenőrzése megtörtént");
        }
        else
        {
            System.out.println("HIBA! A jármű műszaki ellenőrzése nem teljesíthető!");
        }
    }

}
