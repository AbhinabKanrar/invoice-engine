
package com.risefintech.invoicechoice.engine.domain.schema;

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
public class Error {

	private String code;
	private String desc;

}
