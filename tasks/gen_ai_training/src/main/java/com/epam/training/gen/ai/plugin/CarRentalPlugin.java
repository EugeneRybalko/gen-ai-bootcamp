package com.epam.training.gen.ai.plugin;

import com.epam.training.gen.ai.model.Car;
import com.microsoft.semantickernel.semanticfunctions.annotations.DefineKernelFunction;
import com.microsoft.semantickernel.semanticfunctions.annotations.KernelFunctionParameter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CarRentalPlugin {

    private Map<Integer, Car> cars = new HashMap<>();

    public CarRentalPlugin() {
        cars.put(1, new Car(1, "BMW", "Black color, broken door", false));
        cars.put(2, new Car(2, "Mazda", "Black color, broken window", true));
        cars.put(3, new Car(3, "Mercedes", "Red color, broken door", false));
    }

    @DefineKernelFunction(name = "get_cars",
            description = "Gets a list of cars for rental")
    public List<Car> getCars() {
        log.info("Getting list of cars {}", cars.values());
        return new ArrayList<>(cars.values());
    }

    @DefineKernelFunction(name = "rent_car",
            description = "Rent a car")
    public Car rentCar(@KernelFunctionParameter(name = "id", description = "The ID of the car to rent") int id) {
        log.info("Renting car with ID {}", id);
        if (!cars.containsKey(id)) {
            throw new IllegalArgumentException("Car not found");
        }
        cars.get(id).setRented(true);
        return cars.get(id);
    }
}
