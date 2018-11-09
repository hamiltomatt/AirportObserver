
package arcobserver;

/**
 *
 * @author Matthew Hamilton
 */
public class ARCObserver {

    
    public static void main(String[] args) {
        
        final ARC airport = ARC.getAirportControl();
        LoadingBay lb1 = new LoadingBay("A1", 9000, 9000);
        LoadingBay lb2 = new LoadingBay("A2", 12000, 10000);
        LoadingBay lb3 = new LoadingBay("A3", 8000, 7000);
        LoadingBay lb4 = new LoadingBay("A4", 8500, 9000);
        LoadingBay lb5 = new LoadingBay("A5", 5000, 6000);
        ParkingBay pb1 = new ParkingBay("C4", 9000, 9000);
        ParkingBay pb2 = new ParkingBay("C5", 12000, 10000);
        ParkingBay pb3 = new ParkingBay("C6", 8000, 7000);
        ParkingBay pb4 = new ParkingBay("C7", 8500, 9000);
        ParkingBay pb5 = new ParkingBay("C8", 5000, 6000);
        CleaningVehicle clV1 = new CleaningVehicle("W3");
        MaintenanceVehicle mV1 = new MaintenanceVehicle("N5");
        CateringVehicle caV1 = new CateringVehicle("K2");
        FuelVehicle fV1 = new FuelVehicle("F9");
        RampVehicle rV1 = new RampVehicle("O2");
        
        final Plane p1 = new Plane("Boeing 737", "c82h", 7000, 6000, "NO ISSUES", "FULL FUEL", 500, "NOT READY", "CLEAN");
        p1.planeLanding(airport);
        p1.planeTakingOff(airport);
        
        final Plane p2 = new Plane("Boeing 737", "v54r", 7000, 6000, "FAULTY", "FULL FUEL", 500, "READY", "CLEAN");
        p2.planeLanding(airport);
        p2.planeTakingOff(airport);
        
        final Plane p3 = new Plane("Boeing 737", "d34g", 4000, 3000, "NO ISSUES", "LOW", 500, "READY", "CLEAN");
        p3.planeLanding(airport);
        p3.planeTakingOff(airport);
        
    }
    
}
