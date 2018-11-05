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

    private final ArrayList<Plane> Planes;
    private final ArrayList<PlaneWatcher> PlaneWatchers;
    private final ArrayList<Vehicle> Vehicles;

    /**
     * Constructor initialises lists for stored planes and objects watching for
     * planes landing.
     */
    public ARC() 
    {
        this.Planes = new ArrayList<>();
        this.PlaneWatchers = new ArrayList<>();
        this.Vehicles = new ArrayList<>();
    }
    
    /**
     * Adds instance of PlaneWatcher to stored list.
     * @param pW PlaneWatcher instance to add
     * @return If object is now contained in the list
     */
    public boolean addPlaneWatcher(PlaneWatcher pW)
    {
        if(!PlaneWatchers.contains(pW))
        {
            PlaneWatchers.add(pW);
            return PlaneWatchers.contains(pW);
        }
        return false;
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
     * Adds instance of Vehicle to stored list.
     * @param v Vehicle instance to be added
     * @return If adding was successful
     */
    public boolean addVehicle(Vehicle v)
    {
        if(!Vehicles.contains(v))
        {
            Vehicles.add(v);
            return Vehicles.contains(v);
        }
        return false;
    }
    
    /**
     * Removes instance of Vehicle from stored list
     * @param v Vehicle instance to be removed
     * @return If removing was successful
     */
    public boolean removeVehicle(Vehicle v)
    {
        if(Vehicles.contains(v))
        {
            Vehicles.remove(v);
            return !Vehicles.contains(v);
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
     * Calls vehicles needed for plane from store to bay
     * @param b Bay calling vehicles
     */
    public void callVehicles(Bay b)
    {
        for(Vehicle v : Vehicles)
        {
            if(v.isAvailable)
            {
                
            }
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
