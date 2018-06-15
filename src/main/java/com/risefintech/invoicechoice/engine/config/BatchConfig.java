/**
 * 
 */
package com.risefintech.invoicechoice.engine.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;

import com.risefintech.invoicechoice.engine.domain.schema.GenericRequest;
import com.risefintech.invoicechoice.engine.service.batch.Processor;
import com.risefintech.invoicechoice.engine.service.batch.Reader;
import com.risefintech.invoicechoice.engine.service.batch.Writer;

/**
 * @author abhinab
 *
 */
@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("invoice-job").incrementer(new RunIdIncrementer()).flow(step()).end().build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("invoicing-step").<GenericRequest, String>chunk(1).reader(new Reader())
				.processor(new Processor()).writer(new Writer()).faultTolerant()
				.skipLimit(10).skip(DataAccessException.class)
				.build();
	}

}
