/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services;

import bg.home.cars.dtoModels.viewDto.SaleViewDto;
import java.util.List;

/**
 *
 * @author Kalin
 */
public interface SaleService {
	
	List<SaleViewDto> allSales();
}
