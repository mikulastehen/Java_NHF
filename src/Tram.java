public class Tram extends Vehicle
{
    private String pantograph;
    private boolean hasac;
    private String ctlogic;

    public String getType() {return "T";}
    public Tram(String ma, String mo, String pt, String ct, boolean ac, int m, int d, String l)
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
