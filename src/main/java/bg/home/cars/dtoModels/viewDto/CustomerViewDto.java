package bg.home.cars.dtoModels.viewDto;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerViewDto {

	private Long id;
	private String name;
	private Date birthDate;
	private boolean youngDriver;
	private BigDecimal spentMoney; 
	private int carNumbers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCarNumbers() {
		return carNumbers;
	}

	public void setCarNumbers(int carNumbers) {
		this.carNumbers = carNumbers;
	}


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

	public BigDecimal getSpentMoney() {
		return spentMoney;
	}

	public void setSpentMoney(BigDecimal spentMoney) {
		this.spentMoney = spentMoney;
	}

}
