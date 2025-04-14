package com.data.structures.algorithms.java.lld.parkinglot.parking;


import com.data.structures.algorithms.java.lld.parkinglot.vehicle.Vehicle;
import com.data.structures.algorithms.java.lld.parkinglot.vehicle.VehicleType;

public class ParkingSpot {

    private final int spot;
    private final VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot(int spot, VehicleType vehicleType) {
        this.spot = spot;
        this.vehicleType = vehicleType;
    }

    public int getSpotNumber() {
        return this.spot;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void unpark() {
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }
}
