/**
 * 
 */
package com.risefintech.invoicechoice.engine.service.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author abhinab
 *
 */
public class Processor implements ItemProcessor<String, String> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String process(String content) throws Exception {
		return content.toUpperCase();
	}

}
