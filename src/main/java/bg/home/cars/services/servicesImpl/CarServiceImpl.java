/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services.servicesImpl;

import bg.home.cars.dtoModels.viewDto.CarsViewDto;
import bg.home.cars.dtoModels.viewDto.CarsViewDtoWithParts;
import bg.home.cars.dtoModels.viewDto.PartsViewDto;
import bg.home.cars.entity.Car;
import bg.home.cars.entity.Part;
import bg.home.cars.repository.CarsRepository;
import bg.home.cars.services.CarService;
import bg.home.cars.utils.ModelParser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarsRepository carsRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public List<CarsViewDtoWithParts> findAllCarsByMaker(String maker) {
		List<Car> allCars = this.carsRepository.findAllCarsByMaker(maker);
		List<CarsViewDtoWithParts> allViewCars = new ArrayList<>();
		allCars.forEach((allCar) -> {
			CarsViewDtoWithParts carsViewDtoWithParts = this.modelParser.convert(allCar, CarsViewDtoWithParts.class);
			carsViewDtoWithParts.setParts(this.convertParts(allCar.getParts()));
			allViewCars.add(carsViewDtoWithParts);
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

	@Override
	public List<CarsViewDtoWithParts> findAllWhitParts() {
		List<Car> allCars = this.carsRepository.findAll();
		List<CarsViewDtoWithParts> result = new ArrayList();
		for (Car car : allCars) {

			CarsViewDtoWithParts carsViewDtoWithParts = this.modelParser.convert(car, CarsViewDtoWithParts.class);
			carsViewDtoWithParts.setParts(this.convertParts(car.getParts()));
			result.add(carsViewDtoWithParts);
		}
		return result.size() > 0 ? result : null;
	}

	@Override
	public CarsViewDtoWithParts findByIdWhitParts(long id) {
		Car cars = this.carsRepository.findOne(id);
		PropertyMap<Car, CarsViewDtoWithParts> propertyMap = new PropertyMap<Car, CarsViewDtoWithParts>() {
			@Override
			protected void configure() {
				map(source.getParts(), destination.getParts());
			}
		};

		CarsViewDtoWithParts carsViewDtoWithParts = this.modelParser.convert(cars, CarsViewDtoWithParts.class, propertyMap);
		return carsViewDtoWithParts;
	}

	private Set<PartsViewDto> convertParts(Set<Part> parts) {
		Set<PartsViewDto> partsView = new HashSet<>();
		parts.stream().map((part) -> this.modelParser.convert(part, PartsViewDto.class)).forEachOrdered((currentPart) -> {
			partsView.add(currentPart);
		});
		return partsView;
	}

}
