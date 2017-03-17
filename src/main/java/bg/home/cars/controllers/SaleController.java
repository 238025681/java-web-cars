/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.controllers;

import bg.home.cars.dtoModels.viewDto.SaleViewDto;
import bg.home.cars.repository.SaleRepository;
import bg.home.cars.services.SaleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Kalin
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping("")
	public String GetSalePage(Model model) {
		List<SaleViewDto> sales = this.saleService.allSales();
		model.addAttribute("sales", sales);
		model.addAttribute("table", "sale-container");
		return "customer";
	}
	
}
