
package bg.home.cars.controllers;

import bg.home.cars.dtoModels.viewDto.CarsViewDto;
import bg.home.cars.services.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Kalin
 */
@Controller
@RequestMapping("/cars")
public class CarsController {
	
	@Autowired
	private CarService carService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String carsHomePage(Model model) {
		List<CarsViewDto> carsViewDtos = this.carService.findAll();
		List<String> makers = this.carService.findAllMakers();
		model.addAttribute("makers", makers);
		model.addAttribute("cars", carsViewDtos);
		model.addAttribute("table", "cars-container");
		return "customer";
	}
	
	@RequestMapping(value = "/{make}", method = RequestMethod.GET)
	String carsByMakerPage(@PathVariable("make") String make, Model model) {
		List<CarsViewDto> carsViewDtos = this.carService.findAllCarsByMaker(make);
		List<String> makers = this.carService.findAllMakers();
		model.addAttribute("makers", makers);
		model.addAttribute("cars", carsViewDtos);
		model.addAttribute("table", "cars-container");
		return "customer";
	}
	
}
