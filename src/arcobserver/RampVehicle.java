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
public class RampVehicle extends Vehicle {

    public RampVehicle(String l) 
    {
        super(l);
    }

    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setRampType("DELIVERED");
        System.out.println("Ramp successfully loaded passengers and cargo");
    }

    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(this.getIsAvailable())
        {
            if(vT.equals("RAMP"))
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
