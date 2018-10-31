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
public abstract class Bay implements PlaneWatcher {
    
    public String location;
    public Plane plane;
    public final ARC airport;
    
    Bay(ARC a, String l)
    {
        airport = a;
        location = l;
    }

    @Override
    public abstract void update(Plane p);
    
    public boolean acceptPlane(Plane p)
    {
        if(plane == null)
        {
            plane = p;
            return true;
        }
        return false;
    }
    
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
