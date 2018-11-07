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
public class LoadingBay extends Bay {
    
    /**
     * Constructor that takes the airport system and the location of bay
     * @param a Airport that bay is connected to
     * @param l Location string sent to superclass Location
     */
    LoadingBay(ARC a, String l)
    {
        super(a, l);
    }

    /**
     * Action undertaken when plane lands
     * @param p Plane landing
     */
    @Override
    public void update(Plane p) 
    {
        if(plane == null)
        {
            airport.isSuitableBay(this);
        }
    }
    
    /**
     * Method that can call vehicles that can refuel the plane.
     */
    public void getFuel()
    {
        airport.callVehicles(this, VehicleType.FUEL);
    }
    
    /**
     * Method that can call vehicles that can provide catering for the plane.
     */
    public void getCatering()
    {
        airport.callVehicles(this, VehicleType.CATERING);
    }
    
    /**
     * Method that can call vehicles that can provide ramp for the plane.
     */
    public void getRamp()
    {
        airport.callVehicles(this, VehicleType.RAMP);
    }
    
}
