
package com.risefintech.invoicechoice.engine.domain.schema;

import java.util.ArrayList;
import java.util.List;
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
public class GenericResponse {

	private boolean success;

	@JsonProperty("data")
	private Object data;

	@Builder.Default
	private List<Error> errors = new ArrayList<Error>();

}
