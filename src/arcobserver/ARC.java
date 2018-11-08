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

    private static ARC airport;
    private final ArrayList<Plane> Planes;
    private final ArrayList<PlaneWatcher> PlaneWatchers;
    private final ArrayList<Vehicle> Vehicles;
    private final ArrayList<Bay> SuitableBays;

    /**
     * Private constructor initialises lists for stored planes, objects 
     * watching for planes landing, vehicles and currently suitable bays.
     */
    private ARC() 
    {
        this.Planes = new ArrayList<>();
        this.PlaneWatchers = new ArrayList<>();
        this.Vehicles = new ArrayList<>();
        this.SuitableBays = new ArrayList<>();
    }
    
    /**
     * Public static method which returns the ARC of the airport. If it already
     * exists, it returns it, and if it doesn't, it creates a new one to return.
     * This is using the Singleton pattern to make sure only one airport is
     * ever existing in the system at one time.
     * @return ARC class
     */
    public static ARC getAirportControl()
    {
        if(airport == null)
        {
            airport = new ARC();
        }
        return airport;
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
            System.out.println("Added " + pW.getClass().getSimpleName() + " to PlaneWatchers list");
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
            System.out.println("Removed " + pW.getClass().getSimpleName() + " from PlaneWatchers list");
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
            System.out.println("Added " + v.getClass().getSimpleName() + " to Vehicles list");
            return Vehicles.contains(v);
        }
        return false;
    }
    
    /**
     * Removes instance of Vehicle from stored list.
     * @param v Vehicle instance to be removed
     * @return If removing was successful
     */
    public boolean removeVehicle(Vehicle v)
    {
        if(Vehicles.contains(v))
        {
            Vehicles.remove(v);
            System.out.println("Removed " + v.getClass().getSimpleName() + " from Vehicles list");
            return !Vehicles.contains(v);
        }
        return false;
    }
    
    /**
     * When a bay sees that a currently landing plane is suitable for itself,
     * it calls this method to be added to the currently suitable bays.
     * @param b Bay free to take plane
     * @return If operation was successful
     */
    public boolean isSuitableBay(Bay b)
    {
        if(!SuitableBays.contains(b))
        {
            SuitableBays.add(b);
            System.out.println("Added " + b.getClass().getSimpleName() + " to suitable bay list");
            return SuitableBays.contains(b);
        }
        return false;
    }

    /**
     * Return the list of currently suitable bays for a plane
     * @return Get array list of suitable bays
     */
    public ArrayList<Bay> getSuitableBays() 
    {
        return SuitableBays;
    }
   
    /**
     * Method to find most suitable bay out of current list of suited bays for
     * a currently landing plane.
     * @param p Plane to find bay for
     * @return Most suitable bay for the currently landing plane
     */
    public Bay findMostSuitableBay(Plane p)
    {
        Bay mostSuitableLoadingBay = null;
        Bay mostSuitableParkingBay = null;
        int minSizeDifference = 9999;
        int sizeDifference;
        
        for(Bay b : SuitableBays)
        {
            switch(b.getClass().getSimpleName())
            {
                case "ParkingBay":
                    sizeDifference = (b.maxWingspan - p.getWingspan()) + (b.maxLength - p.getLength());
                    if(sizeDifference < minSizeDifference)
                    {
                        minSizeDifference = sizeDifference;
                        mostSuitableParkingBay = b;
                    }
                    break;
                case "LoadingBay":
                    sizeDifference = (b.maxWingspan - p.getWingspan()) + (b.maxLength - p.getLength());
                    if(sizeDifference < minSizeDifference)
                    {
                        minSizeDifference = sizeDifference;
                        mostSuitableLoadingBay = b;
                    }
                    break;
            }
        }
        if(mostSuitableParkingBay != null)
        {
            return mostSuitableParkingBay;
        }
        else if((p.getMaintenanceType().equals("FAULTY")) || (p.getCleaningType().equals("DIRTY")))
        {
            return null;
        }
        else if(mostSuitableLoadingBay == null)
        {
            System.out.println("No available bays");
            return mostSuitableLoadingBay;
        }
        return mostSuitableLoadingBay;
    }
    
    /**
     * Notify each PlaneWatcher instance of new planes arriving. This is using
     * the Observer pattern to tell all objects implementing the PlaneWatcher
     * interface of the newly landing plane.
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
     * Calls vehicles needed for plane from store to bay.
     * @param b Bay calling vehicles
     * @param vT Type of vehicle needed for job
     */
    public void callVehicles(Bay b, VehicleType vT)
    {
        for(Vehicle v : Vehicles)
        {
            v.callVehicle(b, vT);
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
            SuitableBays.clear();
            Planes.add(p);
            SuitableBays.clear();
            notifyOfPlane(p);            
            findNewBay(p);
            System.out.println("A bay has not been found");
        }
        return false;
    }
    
    public boolean findNewBay(Plane p)
    {
        Bay newBay = findMostSuitableBay(p);
        if(newBay != null)
        {
            return newBay.acceptPlane(p);
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
            return !Planes.contains(p);
        }
        return false;
    }
 
}
