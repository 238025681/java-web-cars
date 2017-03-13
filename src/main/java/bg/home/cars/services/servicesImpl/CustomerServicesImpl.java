/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services.servicesImpl;

import bg.home.cars.dtoModels.viewDto.CustomerViewDto;
import bg.home.cars.entity.Customer;
import bg.home.cars.repository.CustomerRepository;
import bg.home.cars.services.CustomerServices;
import bg.home.cars.utils.ModelParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	CustomerRepository custmerRepository;

	@Autowired
	ModelParser modelParser;

	@Override
	public List<CustomerViewDto> findAllCustomer(String order) {
		List<Customer> allCustomers = null;

		if (order.toLowerCase().equals("asc")) {
			allCustomers = this.custmerRepository.findAllCustomersAsc();
		} else {
			allCustomers = this.custmerRepository.findAllCustomersDesc();
		}

		List<CustomerViewDto> result = new ArrayList<>();
		for (Customer customer : allCustomers) {
			CustomerViewDto customerViewDto = modelParser.convert(customer, CustomerViewDto.class);
			result.add(customerViewDto);
		}

		return result.size() > 0 ? result : null;
	}

}
