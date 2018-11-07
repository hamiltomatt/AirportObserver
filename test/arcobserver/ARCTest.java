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
    public void testAddPlaneWatcher()
    {
        final ARC a = ARC.getAirportControl();
        ParkingBay pb = new ParkingBay(a, "W4");
        LoadingBay lb = new LoadingBay(a, "N3");
        assertTrue(a.removePlaneWatcher(pb));
        assertTrue(a.addPlaneWatcher(pb));
        assertTrue(a.removePlaneWatcher(lb));
        assertTrue(a.addPlaneWatcher(lb));
    }
    
    /**
     * Test of removePlaneWatcher method, of class ARC. Watcher is added, 
     * then removed from ARC.
     */
    @Test
    public void testRemovePlaneWatcher()
    {
        final ARC a = ARC.getAirportControl();
        final ParkingBay pb = new ParkingBay(a, "W4");
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
        final ParkingBay pb = new ParkingBay(a, "W4");
        a.removePlaneWatcher(pb);
        assertFalse(a.removePlaneWatcher(pb));
    }
    
}
