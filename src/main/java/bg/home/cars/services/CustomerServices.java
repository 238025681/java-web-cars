
package bg.home.cars.services;

import bg.home.cars.dtoModels.viewDto.CustomerViewDto;
import java.util.List;


public interface CustomerServices {
	
	List<CustomerViewDto> findAllCustomer(String order);
}
