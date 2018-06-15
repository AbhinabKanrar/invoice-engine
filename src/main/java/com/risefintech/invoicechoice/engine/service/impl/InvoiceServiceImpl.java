/**
 * 
 */
package com.risefintech.invoicechoice.engine.service.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.risefintech.invoicechoice.engine.domain.batch.BatchJobParameters;
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
	private final ObjectMapper mapper = new ObjectMapper();

	private ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

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
			try {
				JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
						.addString(BatchJobParameters.INVOICE.name(), mapper.writeValueAsString(request))
						.toJobParameters();
				jobLauncher.run(job, jobParameters);
			} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
					| JobParametersInvalidException | JsonProcessingException e) {
				logger.error(e.getMessage(), e);
			}
		});

		return id;
	}

}
