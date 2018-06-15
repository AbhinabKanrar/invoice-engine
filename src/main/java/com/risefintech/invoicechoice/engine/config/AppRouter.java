/**
 * 
 */
package com.risefintech.invoicechoice.engine.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.risefintech.invoicechoice.engine.domain.schema.Error;
import com.risefintech.invoicechoice.engine.domain.schema.GenericRequest;
import com.risefintech.invoicechoice.engine.domain.schema.GenericResponse;
import com.risefintech.invoicechoice.engine.service.InvoiceService;

/**
 * @author abhinab
 *
 */
@RestController
public class AppRouter {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping(value = "/v1/submit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public GenericResponse submit(@RequestBody(required = true) GenericRequest request) {
		String METHOD_NAME = "submit";
		if (logger.isDebugEnabled()) {
			logger.debug("Entering " + METHOD_NAME);
		}
		GenericResponse response = GenericResponse.builder().build();
		try {
			response.setData(invoiceService.initiateInvoice(request, response.getErrors()));
			if (response.getErrors().isEmpty()) {
				response.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error("Unhandled Error while initiating invoice service", e);
			response.getErrors()
					.add(Error.builder().code("1001").desc("Unable to create invoice at this moment").build());
		} finally {
			logger.debug("Exiting " + METHOD_NAME);
		}
		return response;
	}

}
