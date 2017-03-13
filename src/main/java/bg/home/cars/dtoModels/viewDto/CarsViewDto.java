/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.dtoModels.viewDto;

/**
 *
 * @author Kalin
 */
public class CarsViewDto {

	private String make;

	private String model;

	private long travelledDistance;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getTravelledDistance() {
		return travelledDistance;
	}

	public void setTravelledDistance(long travelledDistance) {
		this.travelledDistance = travelledDistance;
	}

	
}
