import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BusStation {
    private ArrayList<Vehicle> vehicles;
    public BusStation(){
        vehicles = new ArrayList<>();
    }

    public Vehicle addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
        return vehicles.get(vehicles.size()-1);
    }

    public void showAllVehicles(){
        for (Vehicle v: vehicles)
            System.out.println(v.display());
    }

    public float showTotalProfit(){
        float totalProfit = 0;
        for (Vehicle v : vehicles){
            totalProfit+=v.profit();
        }
        return totalProfit;
    }

    public void sortVehicles(){
        Collections.sort(vehicles);
    }
}
