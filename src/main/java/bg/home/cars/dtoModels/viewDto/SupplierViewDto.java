/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.dtoModels.viewDto;

import bg.home.cars.entity.Part;
import java.util.List;

/**
 *
 * @author Kalin
 */
public class SupplierViewDto {

	private Long id;
	private String name;
	private List<Part> parts;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	
}
