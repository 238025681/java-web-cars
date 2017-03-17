package bg.home.cars.controllers;

import bg.home.cars.dtoModels.viewDto.SupplierViewDto;
import bg.home.cars.services.SupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/suppliers")
public class SuppliersController {

	@Autowired
	private SupplierService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String suppliersHomePage(Model model) {
		List<SupplierViewDto> suppliers = this.service.findAll();
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("table", "suppliers-container");
		return "customer";
	}
	
	@RequestMapping(value = "/{importer}", method = RequestMethod.GET)
	String suppliersOrderedPage(@PathVariable("importer") String importer, Model model) {
		List<SupplierViewDto> suppliers = null;
		
		if (importer.equals("importers")) {
			suppliers = this.service.findAllByImporter(Boolean.TRUE);
		}else{
			suppliers = this.service.findAllByImporter(Boolean.FALSE);
		}
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("table", "suppliers-container");
		return "customer";
	}
}
