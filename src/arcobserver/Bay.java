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
public abstract class Bay extends Location implements PlaneWatcher {

    protected final ARC airport;
    private Plane plane;
    public int maxLength;
    public int maxWingspan;
    
    /**
     * Constructor takes the airport system and the location of bay
     * @param a Airport that bay is connected to
     * @param l Location string sent to superclass Location
     */
    Bay(String l)
    {
        super(l);
        airport = ARC.getAirportControl();
        airport.addPlaneWatcher(this);
    }

    /**
     * Abstract method describing which action undertaken by bay when plane lands.
     * @param p Plane landing
     */
    @Override
    public abstract void update(Plane p);
    
    /**
     * Abstract method describing actions undertaken when doing jobs on plane.
     */
    public abstract void workOnPlane();
    
    /**
     * Add bay back to airport if back to operation.
     */
    public void addBay()
    {
        airport.addPlaneWatcher(this);
    }
    
    /**
     * Remove bay if not currently in operation.
     */
    public void removeBay()
    {
        airport.removePlaneWatcher(this);
    }

    /**
     * Get plane currently in bay.
     * @return Plane in bay
     */
    public Plane getPlane() 
    {
        return plane;
    }
      
    /**
     * If plane meets requirements, accept plane into bay
     * @param p Plane to be accepted
     * @return If operation was successful
     */
    public boolean acceptPlane(Plane p)
    {
        if(plane == null)
        {
            plane = p;
            return true;
        }
        return false;
    }
    
    /**
     * Once job is completed, dismiss plane from bay
     * @param p Plane to be dismissed
     * @return If operation was successful
     */
    public boolean dismissPlane(Plane p)
    {
        if(plane != null)
        {
            plane = null;
            return true;
        }
        return false;
    }
    
}
