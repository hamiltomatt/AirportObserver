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
public class ARC {
    
    private ArrayList<Subscriber> Subscribers;

    public ARC() 
    {
        this.Subscribers = new ArrayList<>();
    }
    
    public void subscribe(Subscriber s)
    {
        Subscribers.add(s);
    }
    
    public void unsubscribe(Subscriber s)
    {
        Subscribers.remove(s);
    }
    
    public void notifyOfPlane(Plane p)
    {
        for(Subscriber s : Subscribers)
        {
            s.update(p);
        }
    }
 
}
