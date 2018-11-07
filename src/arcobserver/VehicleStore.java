/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcobserver;

import java.util.ArrayList;

/**
 *
 * @author v8269590
 */
public class VehicleStore extends Location {
    
    private static VehicleStore vehicleStore;
    private final ArrayList<Vehicle> vehiclesInStore;
        
    private VehicleStore(String l) 
    {
        super(l);
        vehiclesInStore = new ArrayList<>();        
    }
    
    public static VehicleStore getVehicleStore()
    {
        if(vehicleStore == null)
        {
            vehicleStore = new VehicleStore("R2");
        }
        return vehicleStore;
    }
    
    public boolean addVehicleToStore(Vehicle v)
    {
        if(!vehiclesInStore.contains(v))
        {
            vehiclesInStore.add(v);
            return vehiclesInStore.contains(v);
        }
        return false;
    }
    
    public boolean removeVehicleInStore(Vehicle v)
    {
        if(vehiclesInStore.contains(v))
        {
            vehiclesInStore.remove(v);
            return !vehiclesInStore.contains(v);
        }
        return false;
    }
    
}
