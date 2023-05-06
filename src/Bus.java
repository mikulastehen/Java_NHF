public class Bus extends Vehicle
{
    private String fuel;
    private boolean access;

    public String getFuel() {
        return fuel;
    }
    public boolean isAccess() {
        return access;
    }


    public Bus(int m, int d, String ma, String mo, String l, String f, boolean a)
    {
        super(m, d, ma, mo, l);
        fuel = f; access = a;
    }

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
