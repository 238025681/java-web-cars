
package bg.home.cars.dtoModels.viewDto;

import java.util.Set;

/**
 *
 * @author Kalin
 */
public class CarsViewDtoWithParts {
	
	private Long id;
	
	private String make;

	private String model;

	private long travelledDistance;
	
	private Set<PartsViewDto> parts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<PartsViewDto> getParts() {
		return parts;
	}

	public void setParts(Set<PartsViewDto> parts) {
		this.parts = parts;
	}
	
}
