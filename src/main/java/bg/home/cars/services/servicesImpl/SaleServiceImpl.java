/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services.servicesImpl;

import bg.home.cars.dtoModels.viewDto.SaleViewDto;
import bg.home.cars.entity.Sale;
import bg.home.cars.repository.SaleRepository;
import bg.home.cars.services.SaleService;
import bg.home.cars.utils.ModelParser;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public List<SaleViewDto> allSales() {
		List<Sale> allSales = this.saleRepository.findAll();
		List<SaleViewDto> result = new ArrayList<>();
		for (Sale sale : allSales) {
			SaleViewDto cuurentSale = this.modelParser.convert(sale, SaleViewDto.class);
			cuurentSale.setPrice(sale.getCar().getParts()
					.stream()
					.map(s -> s.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add));
			result.add(cuurentSale);
		}

		return result.size() > 0 ? result : null;
	}

}
