
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class LoadingBay extends Bay {
    
    /**
     * Constructor that takes the airport system and the location of bay
     * @param l Location string sent to superclass Location
     */
    LoadingBay(String l, int mL, int mW)
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
                if((p.getFuelType().equals("LOW")) || (p.getFoodQuantity() < 500) || (p.getRampType().equals("READY")))
                {
                    System.out.println("Found suitable loading bay");
                    airport.isSuitableBay(this);
                }
            }
        }
    }

    /**
     * When a plane is added to the bay, this method complete jobs plane need 
     * completing. These are the tasks the loading bay can complete, at
     * which point it tells the plane it can take off and dismisses it.
     */    
    @Override
    public void workOnPlane()
    {
        if(getPlane().getFuelType().equals("LOW"))
        {
            getFuel();
        }
        if(getPlane().getFoodQuantity() < 500)
        {
            getCatering();
        }
        if(getPlane().getRampType().equals("READY"))
        {
            getRamp();
        } 
        this.dismissPlane(getPlane());
    }
    
    /**
     * Method that can call vehicles that can refuel the plane.
     */
    public void getFuel()
    {
        System.out.println("Calling fuel vehicles");
        airport.callVehicles(this, VehicleType.FUEL);
    }
    
    /**
     * Method that can call vehicles that can provide catering for the plane.
     */
    public void getCatering()
    {
        System.out.println("Calling catering vehicles");
        airport.callVehicles(this, VehicleType.CATERING);
    }
    
    /**
     * Method that can call vehicles that can provide ramp for the plane.
     */
    public void getRamp()
    {
        System.out.println("Calling ramp vehicles");
        airport.callVehicles(this, VehicleType.RAMP);
    }
    
}
