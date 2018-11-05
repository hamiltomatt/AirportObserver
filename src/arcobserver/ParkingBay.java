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
    ParkingBay(ARC a, String l)
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
            
        }
    }
    
    public void getCleaning()
    {
        System.out.println("cleaned");
    }
    
    public void getMaintenance()
    {
        System.out.println("maintained");
    }
    
}
