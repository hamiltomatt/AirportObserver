
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class ParkingBay extends Bay {
    
    /**
     * Constructor that takes the airport system and the location of bay
     * @param a Airport that bay is connected to
     * @param l Location string sent to superclass Location
     */
    ParkingBay(String l, int mL, int mW)
    {
        super(l, mL, mW);
    }
    
    /**
     * Action undertaken when plane lands
     * @param p Plane landing
     */
    @Override
    public void update(Plane p) 
    {
        if(getPlane() == null)
        {
            if((maxLength >= p.getLength()) && (maxWingspan >= p.getWingspan()))
            {
                if((p.getCleaningType().equals("DIRTY")) || (p.getMaintenanceType().equals("FAULTY")))
                {
                    System.out.println("Found suitable parking bay");
                    airport.isSuitableBay(this);
                }
            }
        }
    }
    
    /**
     * When a plane is added to the bay, this method complete jobs plane need 
     * completing. These are the tasks the parking bay can complete, at
     * which point it tells the plane it can take now move to the loading
     * bay to get ready for takeoff, and then dismisses the plane.
     */ 
    @Override
    public void workOnPlane()
    {
        if(getPlane().getCleaningType().equals("DIRTY"))
        {
            getCleaning();
        }
        if(getPlane().getMaintenanceType().equals("FAULTY"))
        {
            getMaintenance();
        }
        airport.getSuitableBays().clear();
        airport.notifyOfPlaneBayChange(this.getPlane());
        airport.findNewBay(this.getPlane());
        this.dismissPlane(getPlane());
    }
    
    /**
     * Method to call vehicles that can clean a plane.
     */
    public void getCleaning()
    {
        airport.callVehicles(this, VehicleType.CLEANING);
    }
    
    /**
     * Method to call vehicles that can do maintenance on a plane.
     */
    public void getMaintenance()
    {
        airport.callVehicles(this, VehicleType.MAINTENANCE);
    }
    
}
