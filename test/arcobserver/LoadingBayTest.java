/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcobserver;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author v8269590
 */
public class LoadingBayTest {
    
    /**
     * Data showing a refueled plane.
     */
    public static String expectedFuelMessage = "FULL FUEL";
    
    /**
     * Data showing a refilled catering system.
     */
    public static int expectedCateringCount = 800;
    
    /**
     * Data showing a delivered ramp.
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
    public void testUpdate() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 4000, 9000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "CLEAN");
        assertFalse(p.planeLanding(a));
    }

    /**
     * Test of getFuel method, of class LoadingBay. This tests to see if a 
     * plane that needs extra fuel can be seen by a subscribed loading bay,
     * and fixed of the issue by being refueled.
     */
    @Test
    public void testGetFuel() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final FuelVehicle fV = new FuelVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 4000, 9000, "NO ISSUES", "LOW", 500, "NOT READY", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedFuelMessage, p.getFuelType());
    }

    /**
     * Test of getCatering method, of class LoadingBay. This tests to see if a 
     * plane that needs extra catering (food) can be seen by a subscribed 
     * loading bay, and fixed of the issue by adding extra food.
     */
    @Test
    public void testGetCatering() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final CateringVehicle cV = new CateringVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 4000, 9000, "NO ISSUES", "FULL FUEL", 100, "NOT READY", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedCateringCount, p.getFoodQuantity());
    }

    /**
     * Test of getRamp method, of class LoadingBay. This tests to see if a 
     * plane that needs ramps to load passengers/cargo can be seen by a 
     * subscribed loading bay, and delivered to the plane.
     */
    @Test
    public void testGetRamp() {
        final ARC a = ARC.getAirportControl();
        final LoadingBay lb = new LoadingBay("W4", 9000, 9000);
        final RampVehicle rV = new RampVehicle("P4");
        final Plane p = new Plane("Boeing 737", "c82h", 4000, 9000, "NO ISSUES", "LOW", 500, "READY", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedRampMessage, p.getRampType());
    }
    
}
