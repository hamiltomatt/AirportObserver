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
        final ARC a = new ARC();
        assertTrue(a.addPlaneWatcher(new ParkingBay(a, "W4")));
        assertTrue(a.addPlaneWatcher(new LoadingBay(a, "N3")));
    }
    
    /**
     * Test of removePlaneWatcher method, of class ARC. Watcher is added, 
     * then removed from ARC.
     */
    @Test
    public void testRemovePlaneWatcher()
    {
        final ARC a = new ARC();
        final ParkingBay pb = new ParkingBay(a, "W4");
        assertTrue(a.addPlaneWatcher(pb));
        assertTrue(a.removePlaneWatcher(pb));       
    }
    
    /**
     * Test of removePlaneWatcher method, of class ARC. Watcher was not added,
     * so operation should fail.
     */
    @Test
    public void testRemovePlaneWatcherInvalid()
    {
        final ARC a = new ARC();
        final ParkingBay pb = new ParkingBay(a, "W4");
        assertFalse(a.removePlaneWatcher(pb));
    }
    
}
