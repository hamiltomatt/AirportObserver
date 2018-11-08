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
   
    private final String model;
    private final String id;
    private final int wingspan;
    private final int length;
    private String maintenanceType;
    private String fuelType;
    private int foodQuantity;
    private String rampType;
    private String cleaningType;
    
    Plane(String m, String i, int w, int l, String mT, String fT, int fQ, String rT, String cT)
    {
        model = m;
        id = i;
        wingspan = w;
        length = l;
        maintenanceType = mT;
        fuelType = fT;
        foodQuantity = fQ;
        rampType = rT;
        cleaningType = cT;
    }
    
    public boolean planeLanding(ARC a)
    {
        return a.planeLanded(this);
    }
    
    public boolean planeTakingOff(ARC a)
    {
        return a.planeTakeoff(this);
    }
    
    public String getModel() 
    {
        return model;
    }

    public String getId() 
    {
        return id;
    }

    public int getWingspan() 
    {
        return wingspan;
    }

    public int getLength() 
    {
        return length;
    }

    public String getMaintenanceType() 
    {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) 
    {
        this.maintenanceType = maintenanceType;
    }

    public String getFuelType() 
    {
        return fuelType;
    }

    public void setFuelType(String fuelType) 
    {
        this.fuelType = fuelType;
    }

    public int getFoodQuantity() 
    {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) 
    {
        this.foodQuantity = foodQuantity;
    }

    public String getRampType() 
    {
        return rampType;
    }

    public void setRampType(String rampType) 
    {
        this.rampType = rampType;
    }

    public String getCleaningType() 
    {
        return cleaningType;
    }

    public void setCleaningType(String cleaningType) 
    {
        this.cleaningType = cleaningType;
    }
}
