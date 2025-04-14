package com.data.structures.algorithms.java.lld.parkinglot.vehicle;

public class Vehicle {
    protected String licensePlate;
    protected VehicleType vehicleType;

    public Vehicle(String licencePlate, VehicleType vehicleType) {
        this.licensePlate = licencePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public String toString() {
        return vehicleType.name() + ": " + licensePlate;
    }
}
