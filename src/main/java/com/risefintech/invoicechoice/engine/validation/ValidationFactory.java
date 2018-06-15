/**
 * 
 */
package com.risefintech.invoicechoice.engine.validation;

import java.util.List;

import com.risefintech.invoicechoice.engine.domain.schema.Error;
import com.risefintech.invoicechoice.engine.domain.schema.GenericRequest;

/**
 * @author abhinab
 *
 */
public class ValidationFactory extends ValidationUtil {

	public static void validateInvoice(GenericRequest request, List<Error> errors) {
		if (isEmpty(request.getRetailerName())) {
			addError("1002", "Retailer's name must be present", errors);
		}
		if (isEmpty(request.getInvoiceId())) {
			addError("1003", "Invoice ID must be present", errors);
		}
	}

	private static void addError(String code, String desc, List<Error> errors) {
		errors.add(Error.builder().code(code).desc(desc).build());
	}

}
