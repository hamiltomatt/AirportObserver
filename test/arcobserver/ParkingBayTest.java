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
public class ParkingBayTest {
    
    public static String expectedCleanedType = "CLEAN";
    
    public static String expectedMaintainedType = "NO ISSUES";
    /**
     * No-args constructor.
     */
    public ParkingBayTest() 
    {
    }
    
    /**
     * Test of update method, of class ParkingBay.
     */
    @Test
    public void testUpdate() 
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 4000, 9000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "CLEAN");
        assertFalse(p.planeLanding(a));
    }

    /**
     * Test of getCleaning method, of class ParkingBay.
     */
    @Test
    public void testGetCleaning() 
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 4000, 9000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "DIRTY");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedCleanedType, p.getCleaningType());
    }

    /**
     * Test of getMaintenance method, of class ParkingBay.
     */
    @Test
    public void testGetMaintenance() 
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 9000);
        final Plane p = new Plane("Boeing 737", "c82h", 4000, 9000, "FAULTY", "FULL FUEL", 500, "NOT READY", "CLEAN");
        assertTrue(p.planeLanding(a));
        assertEquals(expectedMaintainedType, p.getMaintenanceType());
    }
    
}
