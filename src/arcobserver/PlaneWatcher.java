
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public interface PlaneWatcher {
    
    /**
     * Method which all classes implementing PlaneWatcher will implement,
     * 
     * @param p 
     */
    void update(Plane p);
}
