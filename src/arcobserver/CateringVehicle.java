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
public class CateringVehicle extends Vehicle {

    public CateringVehicle(String l) 
    {
        super(l);
    }

    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setFoodQuantity(800);
        System.out.println("Plane has catering refilled");
    }

    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(this.getIsAvailable())
        {
            if(vT.equals("CATERING"))
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
