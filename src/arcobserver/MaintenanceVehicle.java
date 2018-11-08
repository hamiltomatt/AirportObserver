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
public class MaintenanceVehicle extends Vehicle {

    public MaintenanceVehicle(String l) 
    {
        super(l);
    }

    @Override
    public void doJob(Bay b) 
    {
        b.getPlane().setMaintenanceType("NO ISSUES");
        System.out.println("Plane fixed");
    }

    @Override
    public void callVehicle(Bay b, VehicleType vT) 
    {
        if(this.getIsAvailable())
        {
            if(vT.equals("MAINTENANCE"))
            {
                this.assignVehicleToJob(b);
            }
        }
    }
    
}
