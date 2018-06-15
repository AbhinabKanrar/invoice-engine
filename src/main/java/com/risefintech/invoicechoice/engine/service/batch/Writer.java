/**
 * 
 */
package com.risefintech.invoicechoice.engine.service.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

/**
 * @author abhinab
 *
 */
public class Writer implements ItemWriter<String> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void write(List<? extends String> messages) throws Exception {
		for (String msg : messages) {
			System.out.println("#Writer Step: " + msg);
		}
	}

}
