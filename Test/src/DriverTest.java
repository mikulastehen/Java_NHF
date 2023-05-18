import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest
{
    Driver d1;
    Vehicle v2;
    Driver d2;

    @Before
    public void setUp()
    {
        d1 = new Driver("Bajka Jana");
        d2 = new Driver("Kala Pál");
        v2 = new Bus("Mercedes", "Citaro", "Diesel", true, 3500, 3, "FLR-147");
    }

    @Test
    public void SetNewLicenseTest()
    {
        d1.SetNewLicense('B');
        assertTrue(d1.getLicenses().contains(("B")));
    }

    @Test
    public void RemoveLicenseTest()
    {
        d1.SetNewLicense('T');
        d1.RemoveLicenses('T');
        assertFalse(d1.getLicenses().contains("T"));
    }

    @Test
    public void SetVehicleTest()
    {
        d2.SetNewLicense('B');
        d2.SetVehicle(v2);
        assertSame(v2, d2.getCurrentvehicle());
    }

    @Test
    public void DockTest()
    {
        d2.DockVehicle();
        assertSame(null, d2.getCurrentvehicle());
    }

}
