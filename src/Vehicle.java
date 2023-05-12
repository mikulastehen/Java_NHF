import java.io.Serializable;

public abstract class Vehicle implements Serializable
{
    //Adattagok
    private int mass;
    private int doorcount;
    private int checkreq;
    private String make;
    private String model;
    private Driver activedriver;
    private int lastcheck;
    private String license;
    private boolean onroute;


    //Get Metódusok
    public int getMass() {return mass;}

    public int getDoorcount() {
        return doorcount;
    }

    public Driver getActivedriver() {
        return activedriver;
    }

    public String getLicense() {
        return license;
    }
    public abstract boolean setActiveDriver(Driver d);
    public void SuperSet(Driver d)
    {
        activedriver = d;
    }

    @Override
    public String toString() {
        return make + " " + model + " " + license;
    }

    public Vehicle(int m, int d, String ma, String mo, String l)
    {
        mass = m;
        doorcount = d; make = ma; model = mo; license = l;
        checkreq = 20; lastcheck = 0;
    }
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
    public void CallBack()
    {
        if(onroute)
        {
            onroute = false;
            lastcheck++;
        }
        else System.out.println("HIBA! A jármű nincs forgalomban!");
    }

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
