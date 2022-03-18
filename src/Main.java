public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus("blue", true, 20, 10f);
        Taxi taxi1 = new Taxi("yellow", false, 4, 20f);
        Taxi taxi2 = new Taxi("yellow", true, 3, 15f);
        Taxi taxi3 = new Taxi("black", true, 2, 30f);
        Bus bus2 = new Bus("red", true, 40, 7f);
        bus1.charge();
        bus2.charge();
        bus1.charge();
        taxi1.charge();
        taxi2.charge();
        taxi3.charge();
        taxi2.charge();
        BusStation busStation = new BusStation();
        busStation.addVehicle(bus1);
        busStation.addVehicle(bus2);
        busStation.addVehicle(taxi1);
        busStation.addVehicle(taxi2);
        busStation.addVehicle(taxi3);
        busStation.showAllVehicles();
        System.out.println(busStation.showTotalProfit());
        busStation.sortVehicles();
        busStation.showAllVehicles();


    }
}
