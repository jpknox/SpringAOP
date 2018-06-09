package app.rest.data;

/**
 * Created by joaok on 08/06/2018.
 */
public class Car {

	private String colour;
	private int numWheels;
	private String manufacturer;
	private String model;

	public Car() {
	}

	public Car(String colour, int numWheels, String manufacturer, String model) {
		this.colour = colour;
		this.numWheels = numWheels;
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getNumWheels() {
		return numWheels;
	}

	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
