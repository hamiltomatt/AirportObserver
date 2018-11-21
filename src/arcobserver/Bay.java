
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public abstract class Bay extends Location implements PlaneWatcher {

    /**
     * The bay's local reference to the airport class, which is initialised in
     * the constructor through the airport's static getAirportControl method.
     */
    protected final ARC airport;
    /**
     * The plane currently assigned to the bay, or null if bay is empty.
     */
    private Plane plane = null;
    /**
     * The maximum length of plane the bay can hold.
     */
    public int maxLength;
    /**
     * The maximum wingspan of plane the bay can hold.
     */
    public int maxWingspan;
    
    /**
     * Constructor takes the airport system and the location of bay
     * @param a Airport that bay is connected to
     * @param l Location string sent to superclass Location
     */
    Bay(String l, int mL, int mW)
    {
        super(l);
        System.out.println("Bay created at " + l);
        maxLength = mL;
        maxWingspan = mW;
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
            System.out.println("Plane " + p.getId()+ " has been accepted by " + this.getClass().getSimpleName() + " at " + this.getLocation());
            plane = p;
            workOnPlane();
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
            System.out.println("Plane " + p.getId()+ " has been dismissed by " + this.getClass().getSimpleName() + " at " + this.getLocation());
            plane = null;
            return true;
        }
        return false;
    }
    
}
