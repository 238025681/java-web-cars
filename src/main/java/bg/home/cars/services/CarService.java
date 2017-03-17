package bg.home.cars.services;

import bg.home.cars.dtoModels.viewDto.CarsViewDto;
import bg.home.cars.dtoModels.viewDto.CarsViewDtoWithParts;
import java.util.List;

/**
 *
 * @author Kalin
 */
public interface CarService {

	List<CarsViewDtoWithParts> findAllCarsByMaker(String maker);

	List<CarsViewDto> findAll();

	List<CarsViewDtoWithParts> findAllWhitParts();

	CarsViewDtoWithParts findByIdWhitParts(long id);

	List<String> findAllMakers();
}
