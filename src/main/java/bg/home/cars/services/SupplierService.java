/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.services;

import bg.home.cars.dtoModels.viewDto.SupplierViewDto;
import java.util.List;

public interface SupplierService {

	List<SupplierViewDto> findAll();

	List<SupplierViewDto> findAllByImporter(boolean importer);
}
