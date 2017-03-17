
package bg.home.cars.repository;

import bg.home.cars.entity.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kalin
 */
@Repository
public interface CarsRepository extends JpaRepository<Car, Long>{
	
	@Query("SELECT c FROM Car AS c WHERE c.make = :make ORDER BY c.model ASC, c.travelledDistance DESC")
	List<Car> findAllCarsByMaker(@Param("make") String make);
	
	@Query("SELECT c.make FROM Car AS c GROUP BY c.make")
	List<String> findAllMakers();
}
