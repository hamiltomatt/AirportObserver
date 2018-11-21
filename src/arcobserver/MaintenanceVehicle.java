
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class MaintenanceVehicle extends Vehicle {

    /**
     * Sends location to vehicle super-type
     * @param l Vehicle location
     */
    public MaintenanceVehicle(String l) 
    {
        super(l);
    }

    /**
     * Doing currently assigned maintenance job
     * @param b Bay job is being performed at
     */
    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setMaintenanceType("NO ISSUES");
        System.out.println("Plane fixed");
    }

    /**
     * Calling vehicle for job, sees if suitable and if it is, it assigns job
     * @param b Bay job is located at
     * @param vT Type of vehicle needed for job
     */
    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(vT.equals(VehicleType.MAINTENANCE))
        {
            if(this.getIsAvailable())
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
