/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.repository;

import bg.home.cars.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("SELECT c "
			+ "FROM Customer AS c "
			+ "ORDER BY c.dateOfBirth ASC, c.youngDriver DESC")
	List<Customer> findAllCustomersAsc();
	
	
	@Query("SELECT c "
			+ "FROM Customer AS c "
			+ "ORDER BY c.dateOfBirth DESC, c.youngDriver DESC")
	List<Customer> findAllCustomersDesc();
}
