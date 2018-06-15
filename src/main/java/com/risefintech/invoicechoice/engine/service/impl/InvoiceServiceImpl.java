/**
 * 
 */
package com.risefintech.invoicechoice.engine.service.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.risefintech.invoicechoice.engine.domain.schema.Error;
import com.risefintech.invoicechoice.engine.domain.schema.GenericRequest;
import com.risefintech.invoicechoice.engine.service.InvoiceService;
import com.risefintech.invoicechoice.engine.validation.ValidationFactory;

import static com.risefintech.invoicechoice.engine.util.CommonUtil.generateId;
import static com.risefintech.invoicechoice.engine.validation.ValidationUtil.isEmpty;

/**
 * @author abhinab
 *
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.risefintech.invoicechoice.engine.service.InvoiceService#
	 * initiateInvoice(com.risefintech.invoicechoice.engine.domain.schema.
	 * GenericRequest, java.util.List)
	 */
	@Override
	public String initiateInvoice(GenericRequest request, List<Error> errors) {
		String METHOD_NAME = "submit";
		if (logger.isDebugEnabled()) {
			logger.debug("Entering " + METHOD_NAME);
		}

		ValidationFactory.validateInvoice(request, errors);

		if (!isEmpty(errors)) {
			return null;
		}

		String id = generateId();

		executor.submit(() -> {

		});

		return id;
	}

}
