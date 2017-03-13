/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.repository;

import javax.persistence.EntityManager;

/**
 *
 * @author Kalin
 */
public class EntityMan {
		
		EntityManager entityManager;
	
	void test(){
		entityManager.createQuery("SELECT c.make FROM Car AS c GROUP BY c.make");
	}
}
