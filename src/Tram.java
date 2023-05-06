public class Tram extends Vehicle
{
    private boolean pantograph;
    private boolean hasac;
    private String ctlogic;

    public String getType() {return "T";}
    public Tram(int m, int d, String ma, String mo, String l, boolean pt, boolean ac, String ct)
    {
        super(m, d, ma, mo, l);
        pantograph = pt; hasac = ac; ctlogic = ct;
    }
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
