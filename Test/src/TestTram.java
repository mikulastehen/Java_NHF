import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestTram
{
    Vehicle v1;
    Driver d1;
    @Before
    public void setUp()
    {
        v1 = new Tram("CAF", "Urbos3", "Fél", "tirisztor", true, 5000, 6, "25412");
        d1 = new Driver("Csaba Pista");

    }

    @Test
    public void SetActiveDriverTest()
    {
        assertFalse(v1.setActiveDriver(d1));
        d1.SetNewLicense('T');
        assertTrue(v1.setActiveDriver(d1));
    }


}
