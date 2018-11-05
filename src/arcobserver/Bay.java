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

    public Plane plane;
    public final ARC airport;
    
    /**
     * Constructor takes the airport system and the location of bay
     * @param a Airport that bay is connected to
     * @param l Location string sent to superclass Location
     */
    Bay(ARC a, String l)
    {
        super(l);
        airport = a;
    }

    /**
     * Action undertaken when plane lands
     * @param p Plane landing
     */
    @Override
    public abstract void update(Plane p);
    
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
