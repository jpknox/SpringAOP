package app.rest.data;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaok on 08/06/2018.
 */
@Service
public class CarService {

	private List inventory;

	public CarService() {
		this.inventory = new ArrayList<Car>();
	}

	public boolean add(Car car) {
		return inventory.add(car);
	}

	public boolean remove(Car car) {
		return inventory.remove(car);
	}

	public Car remove(int index) {
		return (Car) inventory.remove(index);
	}

	public List<Car> getAll() {
		return new ArrayList(inventory);
	}

}
