package app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.rest.data.Car;
import app.rest.data.CarService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by joaok on 08/06/2018.
 */
@RestController
public class Autoshop {

	@Autowired
	CarService carService;

	@GetMapping(path = "getCars")
	public Object getCars() {
		return carService.getAll();
	}

	@PostMapping(path = "addCars")
	public List<Object> addCar(@RequestBody ArrayList<Car> cars) {
		List statusOfStorage = new LinkedList<Car>();
		for (Car car: cars) {
			boolean hasBeenAdded = carService.add(car);
			statusOfStorage.add(new InsertionStatus(hasBeenAdded, car));
		}
		return statusOfStorage;
	}

	private class InsertionStatus {

		boolean hasBeenAdded;
		Car car;

		public InsertionStatus(boolean hasBeenAdded, Car car) {
			this.hasBeenAdded = hasBeenAdded;
			this.car = car;
		}

		public boolean isHasBeenAdded() {
			return hasBeenAdded;
		}

		public Car getCar() {
			return car;
		}
	}
}
