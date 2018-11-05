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
public abstract class Vehicle {
    
    String location;
    boolean isAvailable;
    
    public boolean driveTo(Location l)
    {
        System.out.println("Driving to: " + l.location);
        location = l.location;
        return location == l.location;
    }
    
    public abstract boolean doJob(String location);
}
