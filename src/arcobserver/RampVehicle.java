
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class RampVehicle extends Vehicle {

    /**
     * Constructor sending location to supertype
     * @param l Current location
     */
    public RampVehicle(String l) 
    {
        super(l);
    }

    /**
     * Doing currently assigned ramp delivery job
     * @param b Bay job is being performed at
     */
    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setRampType("DELIVERED");
        System.out.println("Ramp successfully loaded passengers and cargo");
    }

    /**
    * Calling vehicle for job, sees if suitable and if it is, it assigns job
    * @param b Bay job is located at
    * @param vT Type of vehicle needed for job
    */
    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(vT.equals(VehicleType.RAMP))
        {
            if(this.getIsAvailable())
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
