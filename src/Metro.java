public class Metro extends Vehicle
{
    private String avr;
    private boolean avron;
    private int wagno;

    public String getType() {return "M";}
    public Metro(int m, int d, String ma, String mo, String l, String avr, boolean avon, int wgn)
    {
        super(m, d, ma, mo, l);
        this.avr = avr; avron = avon; wagno = wgn;
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
