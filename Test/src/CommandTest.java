import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CommandTest
{
    ArrayList<Driver> drivers;
    ArrayList<Vehicle> vehicles;
    AddDriver cmd;
    @Before
    public void setUp()
    {
        drivers = new ArrayList<>();
        vehicles = new ArrayList<>();
        drivers.add(new Driver("Józska Pista"));
        drivers.add(new Driver("Ferenc Jozsef"));
        cmd = new AddDriver(drivers, vehicles);

    }

    @Test
    public void AddDriverTest()
    {

        cmd.Command("nd Béla Bálint");
        assertEquals(3, drivers.size());
    }

    @Test
    public void AddDriverSameTest()
    {
        cmd.Command("nd Béla Bálint");
        assertEquals(3, drivers.size());
    }


}
