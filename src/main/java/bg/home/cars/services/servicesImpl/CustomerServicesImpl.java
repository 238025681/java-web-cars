/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services.servicesImpl;

import bg.home.cars.dtoModels.viewDto.CustomerViewDto;
import bg.home.cars.dtoModels.viewDto.SaleViewDto;
import bg.home.cars.entity.Customer;
import bg.home.cars.entity.Sale;
import bg.home.cars.repository.CustomerRepository;
import bg.home.cars.repository.SaleRepository;
import bg.home.cars.services.CustomerServices;
import bg.home.cars.utils.ModelParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	CustomerRepository custmerRepository;
	
	@Autowired
	SaleRepository saleRepository;

	@Autowired
	ModelParser modelParser;

	@Override
	public List<CustomerViewDto> findAllCustomer(String order) {
		List<Customer> allCustomers = null;
		BigDecimal totalSpendMoney = new BigDecimal(0);

		if (order.toLowerCase().equals("asc")) {
			allCustomers = this.custmerRepository.findAllCustomersAsc();
		} else {
			allCustomers = this.custmerRepository.findAllCustomersDesc();
		}
		
		
		List<CustomerViewDto> result = new ArrayList<>();
		for (Customer customer : allCustomers) {
			CustomerViewDto customerViewDto = modelParser.convert(customer, CustomerViewDto.class);
			
			customerViewDto.setCarNumbers(customer.getSales().size());
			
			BigDecimal spendMoney = customer.getSales().stream().map(
				sale -> sale.getCar().getParts().stream().map(s -> s.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add)
			).reduce(BigDecimal.ZERO, BigDecimal::add);
			
			customerViewDto.setSpentMoney(spendMoney);
			
			if (customerViewDto.getSpentMoney() == null) {
				customerViewDto.setSpentMoney(new BigDecimal(BigInteger.ZERO));
			}
			result.add(customerViewDto);
		}

		return result.size() > 0 ? result : null;
	}

}
