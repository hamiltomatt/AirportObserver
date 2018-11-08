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
     * When a plane is added to the bay, complete jobs plane needs doing.
     */
    @Override
    public void workOnPlane()
    {
        if(getPlane().getCleaningType().equals("DIRTY"))
        {
            getCleaning();
        }
        if(getPlane().getCleaningType().equals("FAULTY"))
        {
            getMaintenance();
        }
        airport.getSuitableBays().clear();
        airport.notifyOfPlane(this.getPlane());
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
