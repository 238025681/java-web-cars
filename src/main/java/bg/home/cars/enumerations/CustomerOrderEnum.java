/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.home.cars.enumerations;

/**
 *
 * @author Kalin
 */
public enum CustomerOrderEnum {
	ASC,
	DESC;

	public static String order(String order) {
		switch (order) {
			case "ascending":
				return ASC.name();
			case "descending":
				return DESC.name();
		}
		return ASC.name();
	}
}
