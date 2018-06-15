/**
 * 
 */
package com.risefintech.invoicechoice.engine.util;

import java.util.UUID;

/**
 * @author abhinab
 *
 */
public class CommonUtil {

	public static String generateId() {
		return UUID.nameUUIDFromBytes(String.valueOf(System.nanoTime()).getBytes()).toString();
	}

}
