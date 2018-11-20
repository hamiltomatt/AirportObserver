
package arcobserver;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew Hamilton
 */
public class ParkingBayTest {
    
    /**
     * Expected cleaningType when a plane has been cleaned.
     */
    public static String expectedCleanedType = "CLEAN";
    
    /**
     * Expected maintenanceType when a plane has been fixed.
     */
    public static String expectedMaintainedType = "NO ISSUES";
    
    /**
     * No-args constructor.
     */
    public ParkingBayTest() 
    {
    }
    
    /**
     * Test of update method, of class ParkingBay. This method tests if a
     * plane with no further actions needed can continue and take off.
     */
    @Test
    public void testUpdateNoBaysValid() 
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "CLEAN");
        assertTrue(p.planeLanding(a));
    }

    /**
     * Test of getCleaning method, of class ParkingBay. This method tests if a
     * plane, when dirty, can call a cleaning vehicle on landing to clean the
     * plane.
     */
    @Test
    public void testGetCleaningValid() 
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "DIRTY");
        final CleaningVehicle cV = new CleaningVehicle("A2");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedCleanedType, p.getCleaningType());
    }
    
    /**
     * Test of getCleaning method, of class ParkingBay. This method tests if a
     * plane, when it's only dusty, will not call the cleaning vehicle.
     */
    @Test
    public void testGetCleaningInvalid() 
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "DUSTY");
        final CleaningVehicle cV = new CleaningVehicle("A2");
        assertTrue(p.planeLanding(a));
        assertNotEquals(expectedCleanedType, p.getCleaningType());
    }

    /**
     * Test of getMaintenance method, of class ParkingBay. This method tests if
     * a maintenance vehicle will be called to the bay when a plane declared
     * faulty is taken.
     */
    @Test
    public void testGetMaintenanceValid() 
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "FAULTY", "FULL FUEL", 500, "NOT READY", "CLEAN");
        final MaintenanceVehicle mV = new MaintenanceVehicle("A2");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedMaintainedType, p.getMaintenanceType());
    }
    
    /**
     * Test of getMaintenance method, of class ParkingBay. This method tests if
     * a maintenance vehicle will not be called if a small error is found, like
     * an indoor light has broken.
     */
    @Test
    public void testGetMaintenanceInvalid() 
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 7000, 6000, "LIGHT BROKEN", "FULL FUEL", 500, "NOT READY", "CLEAN");
        final MaintenanceVehicle mV = new MaintenanceVehicle("A2");
        assertTrue(p.planeLanding(a));
        assertNotEquals(expectedMaintainedType, p.getMaintenanceType());
    }
    
}
