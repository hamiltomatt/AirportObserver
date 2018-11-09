
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class FuelVehicle extends Vehicle {

    /**
     * Constructor sending location to supertype
     * @param l Current location
     */
    public FuelVehicle(String l) 
    {
        super(l);
    }

    /**
     * Doing currently assigned fuel job
     * @param b Bay job is being performed at
     */
    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setFuelType("FULL FUEL");
        System.out.println("Plane successfully refueled");
    }

    /**
    * Calling vehicle for job, sees if suitable and if it is, it assigns job
    * @param b Bay job is located at
    * @param vT Type of vehicle needed for job
    */      
    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(this.getIsAvailable())
        {
            if(vT.equals(VehicleType.FUEL))
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
