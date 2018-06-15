/**
 * 
 */
package com.risefintech.invoicechoice.engine.service;

import java.util.List;

import com.risefintech.invoicechoice.engine.domain.schema.Error;
import com.risefintech.invoicechoice.engine.domain.schema.GenericRequest;

/**
 * @author abhinab
 *
 */
public interface InvoiceService {

	/**
	 * 
	 * initiate invoice creation
	 * 
	 */
	String initiateInvoice(GenericRequest request, List<Error> errors);

}
