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
    
    protected final ARC airport;
    private boolean isAvailable;
    
    /**
     * Constructor for vehicle, which sets a current airport and location,
     * and sends vehicle to vehicle store
     * @param l Current location
     */
    Vehicle(String l)
    {
        super(l);
        airport = ARC.getAirportControl();
        addVehicle();
        System.out.println("New " + this.getClass().getSimpleName() + " at: " + this.getLocation());
        driveToStore();
        isAvailable = true;
    }
    
    /**
     * Add vehicle if its back in operation after being removed.
     */
    public void addVehicle()
    {
        airport.addVehicle(this);
    }
    
    /**
     * Remove vehicle if not currently in operation at airport.
     */
    public void removeVehicle()
    {
        airport.removeVehicle(this);
    }
    
    /**
     * Vehicle has been assigned job at given location. The program now goes
     * through each process, travelling from vehicle store, to location
     * to do job, and then successfully return to vehicle store.
     * @param l Location where job is located
     * @return If job was successful
     */
    public boolean assignVehicleToJob(Bay l)
    {
        isAvailable = false;
        System.out.println("Vehicle " + this.getClass().getSimpleName() + " is assigned to job at: " + l.getLocation());
        if(driveTo(l))
        {
            doJob(l);
            if(driveToStore())
            {
                isAvailable = true;
                return true;
            }            
        }
        return false;
    }
    
    /**
     * Gives vehicle location of new job it can complete, which it travels to.
     * @param l Location instance variable
     * @return If operation was successful
     */
    private boolean driveTo(Location l)
    {
        System.out.println("Driving to: " + l.getLocation());
        VehicleStore.getVehicleStore().removeVehicleInStore(this);
        this.setLocation(l.getLocation());
        if(this.getLocation().equals(l.getLocation()))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Drives back to vehicle store when done with job.
     * @return If operation was successful
     */
    private boolean driveToStore()
    {
        System.out.println("Driving from " + this.getLocation() + " to vehicle store");
        String storeLocation = VehicleStore.getVehicleStore().getLocation();
        this.setLocation(storeLocation);
        VehicleStore.getVehicleStore().addVehicleToStore(this);
        System.out.println("Successfully at vehicle store");
        return this.getLocation().equals(storeLocation);
    }
    
    /**
     * Abstract method fulfilled by subclasses which performs job unique to
     * vehicle 
     * @param b Send bay where job is taking place
     */
    public abstract void doJob(Bay b);
    
    /**
     * Abstract method to ask a vehicle if it can do a particular job.
     * @param b Bay where job is located
     * @param vT Type of vehicle needed for job
     */
    public abstract void callVehicle(Bay b, VehicleType vT);

    /**
     * Return if the vehicle is currently available or if it's working
     * @return If vehicle is available
     */
    protected boolean getIsAvailable() 
    {
        return isAvailable;
    }
          
}
