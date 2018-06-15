
package com.risefintech.invoicechoice.engine.domain.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author abhinab
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericRequest {

	private long id;

	@JsonProperty("retailer_name")
	private String retailerName;

	private String email;

	@JsonProperty("invoice_id")
	private String invoiceId;

	@JsonProperty("date")
	private String date;

	@JsonProperty("due_date")
	private String dueDate;

}
