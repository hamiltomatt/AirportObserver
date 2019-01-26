# AirportObserver
Second-year project to model an airport's runway with an 'observer' design pattern.

## Report
The Observer pattern is used in software design to send a collection of objects a message that
something has changed inside a singular subject. This is commonly used to model one-to-many
dependencies between classes within systems. This can be applied in the subsystem through 2
events that occur: when a plane has landed, and the airport needs to find a bay to handle it, and
when a bay needs a job done and calls all available vehicles that can perform a required job to the
bay. The ARC class (main airport control) handles both events in methods that go through every
registered object of interface PlaneWatcher (bays etc.) or of abstract class Vehicle respectively,
calling the abstract methods the implementing objects define. Through calling all bays suitable for a
plane and collating them, it can then find the most suitable bay for a plane, defined as the smallest
bay the plane can fit in.

### Design Pattern

The observer defines a behavioural pattern used to send a set of objects a notification that
something has changed inside an object. This is usually used for a subject to tell a set of other
objects that the subject has changed state and all the objects stored by the subject need to react or
perform differently due to this new state. To do this, a subject must store a list of different objects
observing the subject, where any type of object needed to be notified can be by using
polymorphism. The observing classes all implement the same interface which declares a method
which, when defined by the class, defines what the object will do to react to the change in the
subject. The subject’s stored list will then be type interface, which is able to store any objects
implementing the declared interface. The subject also contains methods which add or remove
objects from these lists.

The observing classes’ interface declares a method which, when implemented by each of the
observers, will define what the class must do when a change in the subject occurs. The subject then,
as an event is occurring which needs handling, calls a method within itself that will go through each
of the stored objects and call the method each object has implemented to handle the change. This
approach successfully decouples the subject class from each of the observer classes, where
otherwise the methods to update each different type of object would have to be hard-coded into
the subject.

One section using the Observer pattern is the bay management system, shown by the UML diagram
Figure 3 in §5.2. The pattern is being used to model the relationship between a newly arriving
aeroplane and a bay it can be assigned to, as well as the relationship between a newly found job a
bay needs to perform and a vehicle that can complete that job. For the former, an interface
PlaneWatcher is defined, declaring a method called update, which passes through the plane landing
as a parameter, which all objects reacting to new planes must implement.

```
public interface PlaneWatcher {
  void update(Plane p);
}
```

The system defines class ARC, the class which will define the airport’s main control systems. The ARC
then stores an ArrayList of objects implementing the PlaneWatcher interface utilising polymorphism.
The ARC also then can add or remove PlaneWatcher objects when they are added or removed from
the system. When a plane lands it notifies the airport, where it adds it to the airport’s Planes list, and
then calls the notifyOfPlaneLanding method to notify all PlaneWatcher objects currently stored by
the airport of the newly landing plane.

```
public class ARC {
  private final ArrayList<PlaneWatcher> PlaneWatchers;
  public void notifyOfPlaneLanding(Plane p)
  {
    for(PlaneWatcher s : PlaneWatchers)
    {
      s.update(p);
    }
  }
}
```

Both the loading and parking bays extend the abstract class Bay, which implements the
PlaneWatcher interface and leaves the update method abstract. When defined by the concrete
classes, it first checks if there is no plane currently in the bay, which if that is true, it then checks if
the length and wingspan of the plane can fit in the current bay. If that is true, it then checks if any of
the conditions where the bay can help are met, which differs between loading and parking bays. If
that is also true, it then contacts the airport to tell it that a bay has been found and to add it to the
airport’s temporary list of suitable bays.

```
public class LoadingBay extends Bay {
  @Override
  public void update(Plane p)
  {
    if(getPlane() == null)
    {
      if((maxLength &gt;= p.getLength()) &amp;&amp; (maxWingspan &gt;=
      p.getWingspan()))
      {
        if((p.getFuelType().equals(&quot;LOW&quot;)) ||
          (p.getFoodQuantity() &lt; 500) || (p.getRampType().equals(&quot;READY&quot;)))
        {
          System.out.println(&quot;Found suitable loading bay&quot;);
          airport.isSuitableBay(this);
        }
      }
    }
  }
}
```

Once every bay is checked, the airport then goes through every suitable bay that has been found to
find the smallest bay that can fit the plane. It does this by checking the difference between the
plane’s length and wingspan with the maximum length and wingspan of the current bay. The bay
which produces the smallest difference is chosen as the assigned bay. However, parking bays will
always override loading bays, as if there is a serious issue with the plane it needs to be resolved
before preparing to take off. When a plane is assigned to a bay, the bay’s workOnPlane method is
called, which checks which conditions have been met, and calls the vehicles associated with that job.

```
public class ARC {
  private final ArrayList<Vehicle> Vehicles;
  public void callVehicles(Bay b, VehicleType vT)
  {
    for(Vehicle v : Vehicles)
    {
      v.callVehicle(b, vT);
    }
}
```

The Vehicle Management system also implements Observer, as shown by the UML diagram Figure 4
in §5.2. It is performed through class Vehicle, which declares the method callVehicle abstract. The
airport’s method callVehicles can then go through all stored vehicles and, by providing the bay
sending the request and the type of vehicle to find (defined as enumeration VehicleType), the
vehicle checks if it is suitable for the job and if it is available. If those are true, the vehicle assigns
itself to the job through the Vehicle classes’ method assignVehicleToJob. The vehicle marks itself as
unavailable before driving from the vehicle store to the bay location, and then performs the job
defined by the concrete Vehicle subclasses. Once that’s completed, it drives back to the store and
marks itself back as available.

When all jobs are completed, the bay then dismisses the plane (a parking bay will also attempt to
find a relocate it to a loading bay to address further needs). Once a plane is fully dismissed from the
system, the plane is then free to take off, which will remove the plane from the system.

### Critical Review

The observer pattern fits since both implementations model one-to-many dependencies i.e. a
currently landing plane interacts with many bays to choose a suitable one, and an in-progress job at
a bay interacts with many vehicles to send suitable vehicles to the bay. By modelling this
dependency with observer, the system is applying the Open-Closed principle, ensuring the system is
open for extension (new bays can be easily added/removed), and closed to modification (the main
airport class has less hard-coded dependencies, so less editing of direct class is needed). However,
some dependencies exist in the code when specifying trying to find different bay types, which makes
the code more fragile, causing unexpected bugs when edited over time, which could be sorted by
refactoring this code into new classes.

The pattern is usually used to model what a subject should do when an aspect of its internal state
changes, and it usually must update an aspect of each observer directly, using the new state.
Although a plane landing at the airport is an event it must deal with, it doesn’t relate to its own state
or the bay’s states in the same way. The pattern as implemented acts as more of a mediator
between the airport and bay classes than a direct update of a change in state.

### Feedback Review

At the initial pitch, the design for the observer pattern was positive, with some confusion over what
the main ARC class was representing, which was then made clear to define as the airport’s main
control program which stores most of the data and methods the system needs to use. At the code
review, there were comments on how the implemented pattern hadn’t fit the general design ethos
behind the pattern but praised the code behind it. There also wasn’t a full model of the vehicle
classes on the UML diagram, which has been amended to the final diagram.

The system also had the testGetCateringValid test fail its assertEquals statement (testing if the
correct aspect of the plane was changed by completing a job), which was fixed by changing the test’s
plane object, which had a width too small to fit into the test’s loading bay object. There was also
some refactoring needed of the code, specifically in the method findMostSuitableBay in the ARC
class, to remove some repeated blocks and generally simplify it by removing the counter for loading
bay size differences, only keeping the difference between bay and plane size for parking bays and all
bays.
