import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest
{

    Vehicle v1;
    Driver d1;
    Vehicle v2;
    Driver d2;
    Vehicle v3;
    Driver d3;

    @Before
    public void setUp()
    {
        v1 = new Bus("Mercedes", "Citaro", "Diesel", true, 3500, 3, "FLR-250");
        d1 = new Driver("Ferenc Joska");
        v2 = new Bus("Mercedes", "Citaro", "Diesel", true, 3500, 3, "FLR-547");
        d2 = new Driver("Abel Misi");
        d2.SetNewLicense('B');
        v3 = new Bus("Mercedes", "Citaro", "Diesel", true, 3500, 3, "FLR-577");
        d3 = new Driver("István Béla");
        d3.SetNewLicense('B');
    }

    @Test
    public void setVehicleTest()
    {
        v1.setActiveDriver(d1);
        assertSame(null, v1.getActivedriver());
        d1.SetNewLicense('B');
        v1.setActiveDriver(d1);
        assertSame(v1.getActivedriver(), d1);
    }

    @Test
    public void SendOnDriveTest()
    {
        v2.setActiveDriver(d2);
        v2.SendOnDrive();
        v2.CallBack();
        assertEquals(1, v2.getLastcheck());
    }

    @Test
    public void OnrouteTest()
    {
        v2.setActiveDriver(d2);
        assertFalse(v2.getOnroute());
    }

    @Test
    public void CallBackTest()
    {
        v2.SendOnDrive();
        assertTrue(v2.getOnroute());
        v2.CallBack();
        assertFalse(v2.getOnroute());
    }

    @Test
    public void doCheckupTest()
    {
        v3.setActiveDriver(d3);
        v3.SendOnDrive();
        v3.CallBack();
        v3.doCheckup();
        assertEquals(0, v3.getLastcheck());
    }



}
