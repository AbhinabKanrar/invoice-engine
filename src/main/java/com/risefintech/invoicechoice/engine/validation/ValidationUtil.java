/**
 * 
 */
package com.risefintech.invoicechoice.engine.validation;

import java.util.Collection;

/**
 * @author abhinab
 *
 */
public class ValidationUtil {

	public static boolean isEmpty(Object attribute) {
		return attribute == null ? true : attribute.toString().length() == 0 ? true : false;
	}

	public static boolean isEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}

}
