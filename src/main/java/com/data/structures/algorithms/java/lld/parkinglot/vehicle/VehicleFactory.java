package com.data.structures.algorithms.java.lld.parkinglot.vehicle;

public class VehicleFactory {

    public static <T> T getVehicle(Class <T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(clazz + "not found");
        }
    }

    public static Vehicle getVehicleByType(String licensePlate, VehicleType type) {
        switch (type) {
            case VehicleType.CAR -> {
                return new Car(licensePlate);
            }
            case VehicleType.MOTORCYCLE -> {
                return new MotorCycle(licensePlate);
            }
            case VehicleType.TRUCK -> {
                return new Truck(licensePlate);
            }
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}
