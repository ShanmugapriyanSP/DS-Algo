package com.data.structures.algorithms.java.lld.parkinglot;

import com.data.structures.algorithms.java.lld.parkinglot.parking.Level;
import com.data.structures.algorithms.java.lld.parkinglot.parking.ParkingLot;
import com.data.structures.algorithms.java.lld.parkinglot.vehicle.Vehicle;
import com.data.structures.algorithms.java.lld.parkinglot.vehicle.VehicleFactory;
import com.data.structures.algorithms.java.lld.parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Vehicle> vehicles = getVehicles();

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.setLevels(getParkingLevels());

        parkingLot.displayAvailability();

        vehicles.forEach(parkingLot::park);
        parkingLot.displayAvailability();

        vehicles.forEach(vehicle -> {
            try {
                parkingLot.unpark(vehicle);
            } catch (Exception e) {

            }
        });
        parkingLot.displayAvailability();

    }

    private static List<Vehicle> getVehicles() {
        Random random = new Random();
        final VehicleType[] vehicleTypes = {VehicleType.CAR, VehicleType.MOTORCYCLE, VehicleType.TRUCK};
        return IntStream.rangeClosed(1, 50)
                .mapToObj(i -> VehicleFactory.getVehicleByType(UUID.randomUUID().toString().split("-")[0],
                        vehicleTypes[random.nextInt(vehicleTypes.length)]))
                .toList();
    }

    private static List<Level> getParkingLevels() {
        List<Level> levels = new ArrayList<>();
        levels.add(new Level(0, 20));
        levels.add(new Level(1, 20));
        levels.add(new Level(2, 20));
        return levels;
    }
}
