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
public abstract class Bay implements Subscriber {
    
    private String location;
    private Plane plane;
    private final ARC airport;
    
    Bay(ARC a)
    {
        airport = a;
    }

    @Override
    public abstract void update(Plane p);
    
}
