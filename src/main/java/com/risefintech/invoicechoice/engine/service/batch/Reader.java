/**
 * 
 */
package com.risefintech.invoicechoice.engine.service.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author abhinab
 *
 */
public class Reader implements ItemReader<String> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private String[] messages = { "Hello World!", "Welcome to Spring Batch!" };

	private int count = 0;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (count < messages.length) {
			return messages[count++];
		} else {
			count = 0;
		}
		return null;
	}

}
