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
public class Plane {
   
    public String model;
    public String id;
    public String maintenanceType;
    public String fuelType;
    public int foodQuantity;
    public String rampType;
    public String cleaningType;
    
    Plane(String m, String i, String mT, String fT, int fQ, String rT, String cT)
    {
        model = m;
        id = i;
        maintenanceType = mT;
        fuelType = fT;
        foodQuantity = fQ;
        rampType = rT;
        cleaningType = cT;
    }
    
    public void planeLanding(ARC a)
    {
        a.planeLanded(this);
    }
    
    public void planeTakingOff(ARC a)
    {
        a.planeTakeoff(this);
    }
}
