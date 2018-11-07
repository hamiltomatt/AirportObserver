/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcobserver;

/**
 *
 * @author v8269590
 */
public abstract class Vehicle extends Location {
    
    boolean isAvailable;
    
    Vehicle(String l)
    {
        super(l);
    }
    
    /**
     * Gives vehicle location of new job it can complete.
     * @param l Location instance variable
     * @return If operation was successful
     */
    public boolean driveTo(Location l)
    {
        System.out.println("Driving to: " + l.location);
        location = l.location;
        return location == l.location;
    }
    
    public boolean driveToStore()
    {
        System.out.println("Driving to vehicle store");
        String storeLocation = VehicleStore.getVehicleStore().location;
        location = storeLocation;
        return location == storeLocation;
    }
    
    public abstract boolean doJob(String location);
}
