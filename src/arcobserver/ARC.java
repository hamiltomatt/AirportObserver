/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcobserver;

import java.util.ArrayList;

/**
 *
 * @author v8269590
 */
public class ARC {
    
    private ArrayList<Plane> Planes;
    private ArrayList<PlaneWatcher> PlaneWatchers;

    public ARC() 
    {
        this.Planes = new ArrayList<>();
        this.PlaneWatchers = new ArrayList<>();
    }
    
    /**
     * Adds instance of PlaneWatcher to stored list.
     * @param pW PlaneWatcher instance to add
     * @return If object is now contained in the list
     */
    public boolean addPlaneWatcher(PlaneWatcher pW)
    {
        PlaneWatchers.add(pW);
        return PlaneWatchers.contains(pW);
    }
    
    /**
     * Removes instance of PlaneWatcher from stored list.
     * @param pW PlaneWatcher instance to be removed
     * @return If removing was successful
     */
    public boolean removePlaneWatcher(PlaneWatcher pW)
    {
        if(PlaneWatchers.contains(pW))
        {
            PlaneWatchers.remove(pW);
            return !PlaneWatchers.contains(pW);
        }
        return false;
    }
    
    /**
     * Notify each PlaneWatcher instance of new planes arriving.
     * @param p Plane to be notified of.
     */
    public void notifyOfPlane(Plane p)
    {
        for(PlaneWatcher s : PlaneWatchers)
        {
            s.update(p);
        }
    }
    
    /**
     * Called when plane object notifies airport of landing.
     * @param p Plane which has just landed.
     * @return If plane has successfully been processed through the system.
     */
    public boolean planeLanded(Plane p)
    {
        if(!Planes.contains(p))
        {
            Planes.add(p);
            notifyOfPlane(p);
            return true;
        }
        return false;
    }
    
    /**
     * Called when plane object notifies airport of takeoff.
     * @param p Plane taking off from airport.
     * @return If plane has successfully been removed from the system.
     */
    public boolean planeTakeoff(Plane p)
    {
        if(Planes.contains(p))
        {
            Planes.remove(p);
            return true;
        }
        return false;
    }
 
}
