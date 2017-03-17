/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services.servicesImpl;

import bg.home.cars.dtoModels.viewDto.SupplierViewDto;
import bg.home.cars.entity.Supplier;
import bg.home.cars.repository.SupplierRepository;
import bg.home.cars.services.SupplierService;
import bg.home.cars.utils.ModelParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private ModelParser modelParser;

	@Override
	public List<SupplierViewDto> findAll() {

		List<Supplier> supplier = this.supplierRepository.findAll();
		List<SupplierViewDto> result = new ArrayList<>();
		
		supplier.forEach(s -> {
			SupplierViewDto supplierViewDto = this.modelParser.convert(s, SupplierViewDto.class);
			result.add(supplierViewDto);
		});
		
		return result.size() > 0 ? result : null;
	}

	@Override
	public List<SupplierViewDto> findAllByImporter(boolean bool) {
		List<Supplier> supplier = this.supplierRepository.findAllByImporter(bool);
		List<SupplierViewDto> result = new ArrayList<>();
		
		supplier.forEach(s -> {
			SupplierViewDto supplierViewDto = this.modelParser.convert(s, SupplierViewDto.class);
			result.add(supplierViewDto);
		});
		
		return result.size() > 0 ? result : null;
	}

}
