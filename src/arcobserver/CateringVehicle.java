
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class CateringVehicle extends Vehicle {

    /**
     * Constructor sending location to supertype
     * @param l Current location
     */
    public CateringVehicle(String l) 
    {
        super(l);
    }

    /**
     * Doing currently assigned catering job
     * @param b Bay job is being performed at
     */
    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setFoodQuantity(800);
        System.out.println("Plane has catering refilled");
    }

    /**
    * Calling vehicle for job, sees if suitable and if it is, it assigns job
    * @param b Bay job is located at
    * @param vT Type of vehicle needed for job
    */    
    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(vT.equals(VehicleType.CATERING))
        {
            if(this.getIsAvailable())
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
