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
    public boolean doJob(String l) {
        isAvailable = false;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
