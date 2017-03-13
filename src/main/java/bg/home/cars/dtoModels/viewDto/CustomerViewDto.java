
package bg.home.cars.dtoModels.viewDto;

import java.util.Date;


public class CustomerViewDto {

	private String name;
	private Date birthDate;
	private boolean youngDriver;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isYoungDriver() {
		return youngDriver;
	}

	public void setYoungDriver(boolean youngDriver) {
		this.youngDriver = youngDriver;
	}
	
	
}
