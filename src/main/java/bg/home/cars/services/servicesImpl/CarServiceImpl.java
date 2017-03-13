/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services.servicesImpl;

import bg.home.cars.dtoModels.viewDto.CarsViewDto;
import bg.home.cars.entity.Car;
import bg.home.cars.repository.CarsRepository;
import bg.home.cars.services.CarService;
import bg.home.cars.utils.ModelParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarsRepository carsRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public List<CarsViewDto> findAllCarsByMaker(String maker) {
		List<Car> allCars = this.carsRepository.findAllCarsByMaker(maker);
		List<CarsViewDto> allViewCars = new ArrayList<>();
		allCars.forEach((allCar) -> {
			CarsViewDto carsViewDto = this.modelParser.convert(allCar, CarsViewDto.class);
			allViewCars.add(carsViewDto);
		});

		return allViewCars.size() > 0 ? allViewCars : null;
	}

	@Override
	public List<CarsViewDto> findAll() {
		List<Car> allCars = this.carsRepository.findAll();
		List<CarsViewDto> allViewCars = new ArrayList<>();
		allCars.forEach((allCar) -> {
			CarsViewDto carsViewDto = this.modelParser.convert(allCar, CarsViewDto.class);
			allViewCars.add(carsViewDto);
		});

		return allViewCars.size() > 0 ? allViewCars : null;
	}

	@Override
	public List<String> findAllMakers() {
		return this.carsRepository.findAllMakers();
	}

}
