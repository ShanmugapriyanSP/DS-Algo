package com.data.structures.algorithms.java.lld.parkinglot.parking;

import com.data.structures.algorithms.java.lld.parkinglot.vehicle.Vehicle;
import com.data.structures.algorithms.java.lld.parkinglot.vehicle.VehicleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private static final Logger logger = LoggerFactory.getLogger(Level.class.getName());

    private final int level;

    private List<ParkingSpot> parkingSpots;

    public Level(int level, int count) {
        this.level = level;
        this.parkingSpots = new ArrayList<>();
        addParkingSpots(count);
    }

    public int getLevel() {
        return this.level;
    }

    public void addParkingSpots(int count) {
        int numOfBikes = (int) (count * 0.4);
        int numOfCars = (int) (count * 0.4);

        for (int i = 1; i <= numOfBikes; i++)
            this.parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));

        for (int i = numOfBikes + 1; i <= numOfBikes + numOfCars; i++)
            this.parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));

        for (int i = numOfBikes + numOfCars + 1; i <= count; i++)
            this.parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
    }

    public synchronized void park(Vehicle vehicle) {
        parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicle.getVehicleType())
                .findFirst()
                .ifPresentOrElse(
                        parkingSpot -> {
                            parkingSpot.park(vehicle);
                            logger.info("{} is parked in level {}", vehicle, level);
                        },
                        () -> logger.info("Parking spots are not available in the level {}", level)
                );

    }

    public synchronized void unpark(Vehicle vehicle) {
        parkingSpots.stream()
                .filter(parkingSpot -> !parkingSpot.isAvailable() && parkingSpot.getVehicle() == vehicle)
                .findFirst()
                .ifPresent(ParkingSpot::unpark);
    }

    public boolean hasParkingSpot() {
        return parkingSpots.stream().anyMatch(ParkingSpot::isAvailable);
    }

    public boolean isVehicleParked(Vehicle vehicle) {
        return parkingSpots.stream().anyMatch(parkingSpot -> !parkingSpot.isAvailable() && parkingSpot.getVehicle() == vehicle);
    }

    public Long availableSpots() {
        return parkingSpots.stream().filter(ParkingSpot::isAvailable).count();
    }

    public Long parkedSpots() {
        return parkingSpots.stream().filter(parkingSpot -> !parkingSpot.isAvailable()).count();
    }

    public Long getAvailableSpotsByVehicleType(VehicleType vehicleType) {
        return parkingSpots.stream()
                .filter(parkingSpot ->
                        parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicleType)
                .count();
    }

    public Long getFilledSpotsByVehicleType(VehicleType vehicleType) {
        return parkingSpots.stream()
                .filter(parkingSpot ->
                        !parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicleType)
                .count();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Level ").append(level).append("\n======================\n");
        stringBuffer.append("BIKE:\n" + "Available Spots: ").
                append(getAvailableSpotsByVehicleType(VehicleType.MOTORCYCLE)).
                append("\nFilled Spots: ").
                append(getFilledSpotsByVehicleType(VehicleType.MOTORCYCLE));
        stringBuffer.append("\n------------------------\n");
        stringBuffer.append("CAR:\n" + "Available Spots: ").
                append(getAvailableSpotsByVehicleType(VehicleType.CAR)).
                append("\nFilled Spots: ").
                append(getFilledSpotsByVehicleType(VehicleType.CAR));
        stringBuffer.append("\n------------------------\n");
        stringBuffer.append("TRUCK:\n" + "Available Spots: ").
                append(getAvailableSpotsByVehicleType(VehicleType.TRUCK)).
                append("\nFilled Spots: ").
                append(getFilledSpotsByVehicleType(VehicleType.TRUCK));
        stringBuffer.append("\n======================\n");
        return stringBuffer.toString();
    }

}
