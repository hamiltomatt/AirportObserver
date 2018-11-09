
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class Plane {
   
    /**
     * The model of the plane.
     */
    private final String model;
    /**
     * The unique id of the plane.
     */
    private final String id;
    /**
     * The wingspan of the plane.
     */
    private final int wingspan;
    /**
     * The length of the plane.
     */
    private final int length;
    /**
     * The maintenance needed for the plane.
     */
    private String maintenanceType;
    /**
     * The fuel needed for the plane.
     */
    private String fuelType;
    /**
     * The number of food items that plane has.
     */
    private int foodQuantity;
    /**
     * The ramps currently needed for the plane.
     */
    private String rampType;
    /**
     * The cleaning needed for the plane.
     */
    private String cleaningType;
    
    /**
     * Constructor to initialise all variables of new plane
     * @param m The model of the plane
     * @param i The unique id of the plane
     * @param w The wingspan of the plane
     * @param l The length of the plane
     * @param mT The maintenance needed for the plane
     * @param fT The fuel needed for the plane
     * @param fQ The number of food items that plane has
     * @param rT The ramps currently needed for the plane
     * @param cT The cleaning needed for the plane
     */
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
    
    /**
     * Tells airport that plane is currently landing.
     * @param a Airport plane is landing at
     * @return If operation was successful
     */
    public boolean planeLanding(ARC a)
    {
        return a.planeLanded(this);
    }
    
    /**
     * Tells airport that plane is taking off.
     * @param a Airport plane is currently at
     * @return If operation was successful
     */
    public boolean planeTakingOff(ARC a)
    {
        return a.planeTakeoff(this);
    }
    
    /**
     * Get model of the plane
     * @return Model string
     */
    public String getModel() 
    {
        return model;
    }

    /**
     * Get unique id of the plane
     * @return Id string
     */
    public String getId() 
    {
        return id;
    }

    /**
     * Get wingspan of the plane
     * @return Wingspan of plane
     */
    public int getWingspan() 
    {
        return wingspan;
    }

    /**
     * Get length of plane.
     * @return Length of plane
     */
    public int getLength() 
    {
        return length;
    }

    /**
     * Get maintenance status for plane
     * @return Maintenance type
     */
    public String getMaintenanceType() 
    {
        return maintenanceType;
    }

    /**
     * Set new maintenance status for plane
     * @param maintenanceType Maintenance status
     */
    public void setMaintenanceType(String maintenanceType) 
    {
        this.maintenanceType = maintenanceType;
    }

    /**
     * Get fuel status of plane
     * @return Fuel type
     */
    public String getFuelType() 
    {
        return fuelType;
    }

    /**
     * 
     * @param fuelType 
     */
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
