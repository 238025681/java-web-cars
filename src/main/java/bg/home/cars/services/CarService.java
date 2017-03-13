/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services;

import bg.home.cars.dtoModels.viewDto.CarsViewDto;
import java.util.List;

/**
 *
 * @author Kalin
 */
public interface CarService {

	List<CarsViewDto> findAllCarsByMaker(String maker);

	List<CarsViewDto> findAll();

	List<String> findAllMakers();
}
