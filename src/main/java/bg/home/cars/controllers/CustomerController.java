/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.controllers;

import bg.home.cars.dtoModels.viewDto.CustomerViewDto;
import bg.home.cars.enumerations.CustomerOrderEnum;
import bg.home.cars.services.CustomerServices;
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
@RequestMapping("/customers/all")
public class CustomerController {
	
	@Autowired
	CustomerServices customerServices;

	@RequestMapping(value = "", method = RequestMethod.GET)
	String costomerHomePage(Model model) {
		List<CustomerViewDto> customerViewDto = customerServices.findAllCustomer(CustomerOrderEnum.ASC.name());
		model.addAttribute("customers", customerViewDto);
		model.addAttribute("table", "container");
		return "customer";
	}
	
	@RequestMapping(value = "/{order}", method = RequestMethod.GET)
	String costomerOrderedPage(@PathVariable("order") String order, Model model) {
		List<CustomerViewDto> customerViewDto = customerServices.findAllCustomer(CustomerOrderEnum.order(order));
		model.addAttribute("customers", customerViewDto);
		model.addAttribute("table", "container");
		return "customer";
	}
	
	
}
