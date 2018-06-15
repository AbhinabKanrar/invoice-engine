/**
 * 
 */
package com.risefintech.invoicechoice.engine.service.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.risefintech.invoicechoice.engine.domain.batch.BatchJobParameters;
import com.risefintech.invoicechoice.engine.domain.schema.GenericRequest;

/**
 * @author abhinab
 *
 */
public class Reader implements ItemReader<GenericRequest> {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final ObjectMapper mapper = new ObjectMapper();

	private String param;
	private int count;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		param = stepExecution.getJobExecution().getJobParameters().getString(BatchJobParameters.INVOICE.name());
		count = 1;
	}

	@Override
	public GenericRequest read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (count > 1) {
			logger.debug("Read op successfully completed");
			return null;
		}
		count++;
		return mapper.readValue(param, GenericRequest.class);
	}

}
