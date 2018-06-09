package app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.rest.data.Car;
import app.rest.data.CarService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by joaok on 08/06/2018.
 */
@RestController
public class InboundAutoshop {

	@Autowired
	CarService carService;

	@GetMapping(path = "getCars")
	public Object getCars(
			@RequestHeader Map headers) {
		return carService.getAll();
	}

	@PostMapping(path = "addCars")
	public Object addCar(
			@RequestHeader Map headers,
			@RequestBody ArrayList<Car> cars) {
		List statusOfStorage = new LinkedList<Car>();
		for (Car _car: cars) {
			boolean _hasBeenAdded = carService.add(_car);
			statusOfStorage.add(new Object() {
				boolean hasBeenAdded = _hasBeenAdded;
				Car car = _car;

				public boolean isHasBeenAdded() {
					return hasBeenAdded;
				}

				public Object getCar() {
					return car;
				}
			});
		}
		return statusOfStorage;
	}
}
