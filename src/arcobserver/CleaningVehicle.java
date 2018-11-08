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
public class CleaningVehicle extends Vehicle {

    public CleaningVehicle(String l) 
    {
        super(l);
    }

    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setCleaningType("CLEAN");
        System.out.println("Plane successfully cleaned");
    }

    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(this.getIsAvailable())
        {
            if(vT.equals("CLEANING"))
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
