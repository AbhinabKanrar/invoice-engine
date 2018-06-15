/**
 * 
 */
package com.risefintech.invoicechoice.engine.service.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.risefintech.invoicechoice.engine.domain.schema.GenericRequest;

/**
 * @author abhinab
 *
 */
public class Processor implements ItemProcessor<GenericRequest, String> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String process(GenericRequest request) throws Exception {
		return request.toString();
	}

}
