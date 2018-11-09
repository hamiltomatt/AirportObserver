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
public class ARCTest {
    
    /**
     * No-args constructor.
     */
    public ARCTest() 
    {
    }

    /**
     * Test of addPlaneWatcher method, of class ARC.
     */
    @Test
    public void testAddPlaneWatcherValid()
    {
        final ARC a = ARC.getAirportControl();
        ParkingBay pb = new ParkingBay("W4", 9000, 4000);
        LoadingBay lb = new LoadingBay("N3", 9000, 4000);
        assertTrue(a.removePlaneWatcher(pb));
        assertTrue(a.addPlaneWatcher(pb));
        assertTrue(a.removePlaneWatcher(lb));
        assertTrue(a.addPlaneWatcher(lb));
    }
    
    /**
     * Test of addPlaneWatcher method, of class ARC. Watcher was already added,
     * so operation should fail.
     */
    @Test
    public void testAddPlaneWatcherInvalid()
    {
        final ARC a = ARC.getAirportControl();
        ParkingBay pb = new ParkingBay("A2", 9000, 4000);
        a.addPlaneWatcher(pb);
        assertFalse(a.addPlaneWatcher(pb));
    }
    
    /**
     * Test of removePlaneWatcher method, of class ARC. Watcher is added, 
     * then removed from ARC.
     */
    @Test
    public void testRemovePlaneWatcherValid()
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 4000);
        assertTrue(a.removePlaneWatcher(pb));       
    }
    
    /**
     * Test of removePlaneWatcher method, of class ARC. Watcher was removed,
     * so operation should fail.
     */
    @Test
    public void testRemovePlaneWatcherInvalid()
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay("W4", 9000, 4000);
        a.removePlaneWatcher(pb);
        assertFalse(a.removePlaneWatcher(pb));
    }
    
    /**
     * Test of addVehicle method, of class ARC. Vehicle was added when created
     * then removed and then re-added, so it should succeed.
     */
    @Test
    public void testAddVehicleValid()
    {
        final ARC a = ARC.getAirportControl();
        final MaintenanceVehicle mV = new MaintenanceVehicle("Q3");
        a.removeVehicle(mV);
        assertTrue(a.addVehicle(mV));
    }
    
    /**
     * Test of removeVehicle method, of class ARC. Vehicle is added when
     * created then removed from ARC.
     */
    @Test
    public void testRemoveVehicleValid()
    {
        final ARC a = ARC.getAirportControl();
        final MaintenanceVehicle mV = new MaintenanceVehicle("Q3");
        assertTrue(a.removeVehicle(mV));
    }
    
    /**
     * Test of removeVehicle method, of class ARC. Vehicle is added when 
     * created, then removed, and then removed again, so operation should fail.
     */
    @Test
    public void testRemoveVehicleInvalid()
    {
        final ARC a = ARC.getAirportControl();
        final CateringVehicle cV = new CateringVehicle("L9");
        a.removeVehicle(cV);
        assertFalse(a.removeVehicle(cV));
    }
    
}
