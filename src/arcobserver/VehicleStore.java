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
public class VehicleStore extends Location {
    
    private final ARC airport;
    private static VehicleStore vehicleStore;
    private final ArrayList<Vehicle> vehiclesInStore;
    
    /**
     * Private constructor, which sets a location
     * @param l Location of vehicle store
     */
    private VehicleStore(String l) 
    {
        super(l);
        airport = ARC.getAirportControl();
        vehiclesInStore = new ArrayList<>();        
    }
    
    /**
     * Public static method which returns the vehicle store of the airport.
     * If it already exists, return it, and if it doesn't exist, it creates a
     * new one to return. This is using the Singleton pattern to ensure only
     * one vehicle store is in the system at one time.
     * @return The vehicle store of the airport.
     */
    public static VehicleStore getVehicleStore()
    {
        if(vehicleStore == null)
        {
            vehicleStore = new VehicleStore("R2");
        }
        return vehicleStore;
    }
    
    /**
     * Adds vehicle to stored list of stored vehicles
     * @param v Vehicle to be added
     * @return If operation was successful
     */
    public boolean addVehicleToStore(Vehicle v)
    {
        if(!vehiclesInStore.contains(v))
        {
            vehiclesInStore.add(v);
            return vehiclesInStore.contains(v);
        }
        return false;
    }
    
    /**
     * Removes vehicle from stored list of stored vehicles
     * @param v Vehicle to be removed
     * @return If operation was successful
     */
    public boolean removeVehicleInStore(Vehicle v)
    {
        if(vehiclesInStore.contains(v))
        {
            vehiclesInStore.remove(v);
            return !vehiclesInStore.contains(v);
        }
        return false;
    }
    
}
