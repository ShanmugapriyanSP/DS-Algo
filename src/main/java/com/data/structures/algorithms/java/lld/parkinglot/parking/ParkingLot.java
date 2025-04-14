package com.data.structures.algorithms.java.lld.parkinglot.parking;

import com.data.structures.algorithms.java.lld.parkinglot.vehicle.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ParkingLot {

    private static final Logger logger = LoggerFactory.getLogger(ParkingLot.class.getName());

    private static ParkingLot instance;

    private List<Level> levels;

    private ParkingLot(){}

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                instance = new ParkingLot();
            }
        }
        return instance;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void displayAvailability() {
        levels.forEach(level ->
                logger.info("{}", level)
        );
    }

    public synchronized void park(Vehicle vehicle) {
        levels.stream()
                .filter(Level::hasParkingSpot)
                .findFirst()
                .ifPresentOrElse(
                        level -> {
                            logger.info("Entering into Level {}", level.getLevel());
                            level.park(vehicle);
                        },
                        () -> logger.info("Sorry!! No parking space available...")
                );
    }

    public synchronized void unpark(Vehicle vehicle) throws Exception {
        Level level = levels.stream()
                .filter(parkingLevel -> parkingLevel.isVehicleParked(vehicle))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Something wrong!!"));

        level.unpark(vehicle);
        logger.info("Leaving level - {}", level.getLevel());
    }
}
