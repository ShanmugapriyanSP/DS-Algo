package com.data.structures.algorithms.java.lld.elevator;

import com.data.structures.algorithms.java.lld.elevator.core.Elevator;
import com.data.structures.algorithms.java.lld.elevator.core.ElevatorManager;
import com.data.structures.algorithms.java.lld.elevator.models.Floor;
import com.data.structures.algorithms.java.lld.elevator.models.People;
import com.github.javafaker.Faker;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ElevatorSystem {

    public static void main(String[] args) {
        Faker faker = new Faker();
        ElevatorManager elevatorManager = ElevatorManager.getInstance();

        for(int i = 0; i < 10; i++) {
            new Elevator(i+1, 25, elevatorManager);
        }
        elevatorManager.startElevators();
        List<People> people = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            people.add(new People(faker.name().fullName()));
        }
        for (People p: people) {
            elevatorManager.requestElevator(p, getRandomFloor());
        }
        while (true){}
    }

    public static SimpleEntry<Floor, Floor> getRandomFloor() {
        int source = ThreadLocalRandom.current().nextInt(0, 11);
        int destination = ThreadLocalRandom.current().nextInt(0, 11);
        while(source == destination) {
            destination = ThreadLocalRandom.current().nextInt(0, 11);
        }
        return new SimpleEntry<>(Floor.get(source), Floor.get(destination));
    }
}
