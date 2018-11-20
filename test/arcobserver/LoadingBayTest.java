
package arcobserver;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew Hamilton
 */
public class LoadingBayTest {
    
    /**
     * Expected fuelType when a plane has been refueled by fuel vehicles.
     */
    public static String expectedFuelMessage = "FULL FUEL";
    
    /**
     * Expected food quantity when a catering vehicle has refilled the plane.
     */
    public static int expectedCateringCount = 800;
    
    /**
     * Expected rampType when a ramp has been delivered to the plane.
     */
    public static String expectedRampMessage = "DELIVERED";
    
    /**
     * No-args constructor.
     */
    public LoadingBayTest() 
    {
    }

    /**
     * Test of update method, of class LoadingBay. This tests to see if a plane
     * that has no extra needs lands, at which point it will be
     * ready to take off again.
     */
    @Test
    public void testUpdateNoBaysValid() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "CLEAN");
        assertTrue(p.planeLanding(a));
    }

    /**
     * Test of getFuel method, of class LoadingBay. This tests to see if a 
     * plane that needs extra fuel can be seen by a subscribed loading bay,
     * and fixed of the issue by being refueled.
     */
    @Test
    public void testGetFuelValid() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final FuelVehicle fV = new FuelVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "LOW", 500, "NOT READY", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedFuelMessage, p.getFuelType());
    }
    
    /**
     * Test of getFuel method, of class LoadingBay. This tests to see if a
     * plane that has some fuel but enough for a journey is not delivered
     * fuel by an available fuel vehicle.
     */
    @Test
    public void testGetFuelInvalid() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final FuelVehicle fV = new FuelVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "SOME FUEL", 500, "NOT READY", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertNotEquals(expectedFuelMessage, p.getFuelType());
    }

    /**
     * Test of getCatering method, of class LoadingBay. This tests to see if a 
     * plane that needs extra catering (food) can be seen by a subscribed 
     * loading bay, and fixed of the issue by adding extra food.
     */
    @Test
    public void testGetCateringValid() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final CateringVehicle cV = new CateringVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "FULL FUEL", 100, "NOT READY", "CLEAN");
        p.planeLanding(a);
        assertEquals(expectedCateringCount, p.getFoodQuantity());
    }
    
    /**
     * Test of getCatering method, of class LoadingBay. This tests to see if a
     * plane that doesn't need extra food can, even though a catering vehicle
     * is available, will not deliver additional food.
     */
    @Test
    public void testGetCateringInvalid() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final CateringVehicle cV = new CateringVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertNotEquals(expectedCateringCount, p.getFoodQuantity());
    }

    /**
     * Test of getRamp method, of class LoadingBay. This tests to see if a 
     * plane that needs ramps to load passengers/cargo can be seen by a 
     * subscribed loading bay, and delivered to the plane.
     */
    @Test
    public void testGetRampValid() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final RampVehicle rV = new RampVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "LOW", 500, "READY", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedRampMessage, p.getRampType());
    }
    
    /**
     * Test of getRamp method, of class LoadingBay. This tests to see if a
     * plane that is waiting needs a ramp, which it doesn't, so a ramp isn't
     * delivered and the test fails.
     */
    @Test
    public void testGetRampInvalid() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final RampVehicle rV = new RampVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "LOW", 500, "WAITING", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertNotEquals(expectedRampMessage, p.getRampType());
    }
    
}
