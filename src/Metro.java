public class Metro extends Vehicle
{
    private String avr;
    private boolean avron;
    private int wagno;

    public String getType() {return "M";}
    public Metro(String ma, String mo, String avr, int wgn, int m, int d, String l)
    {
        super(m, d, ma, mo, l);
        this.avr = avr; avron = false; wagno = wgn;
    }

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
