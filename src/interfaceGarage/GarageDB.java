package interfaceGarage;

import java.util.*;

public class GarageDB {
    private Map<Integer, Queue<Vehicle>> vehicleMap;

    public GarageDB() {
        vehicleMap = new HashMap<>();
        vehicleMap.put(1, new LinkedList<>());
        vehicleMap.put(2, new LinkedList<>());
        vehicleMap.put(3, new LinkedList<>());
    }

    public void build(int type, String model) {
        if (!vehicleMap.containsKey(type)) {
            System.out.println("Invalid type: " + type);
            return;
        }
        Vehicle v = switch (type) {
            case 1 -> MotorCycle.build(model);
            case 2 -> Car.build(model);
            case 3 -> Truck.build(model);
            default -> throw new IllegalArgumentException("Invalid type: " + type);
        };
        vehicleMap.get(type).offer(v);
    }

    public List<Vehicle> getVehicles() {
        List<Vehicle> sortedVehicles = new ArrayList<>();
        sortedVehicles.addAll(vehicleMap.get(1));
        sortedVehicles.addAll(vehicleMap.get(2));
        sortedVehicles.addAll(vehicleMap.get(3));
        return sortedVehicles;
    }

    public void printVehicles() {
        for (int key : vehicleMap.keySet()) {
            System.out.println("Queue " + key + ": " + vehicleMap.get(key));
        }
    }
}