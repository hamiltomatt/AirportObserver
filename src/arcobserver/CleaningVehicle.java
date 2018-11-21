
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class CleaningVehicle extends Vehicle {

    /**
     * Constructor sending location to supertype
     * @param l Current location
     */
    public CleaningVehicle(String l) 
    {
        super(l);
    }

    /**
     * Doing currently assigned cleaning job
     * @param b Bay job is being performed at
     */
    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setCleaningType("CLEAN");
        System.out.println("Plane successfully cleaned");
    }

    /**
    * Calling vehicle for job, sees if suitable and if it is, it assigns job
    * @param b Bay job is located at
    * @param vT Type of vehicle needed for job
    */
    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(vT.equals(VehicleType.CLEANING))
        {
            if(this.getIsAvailable())
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
