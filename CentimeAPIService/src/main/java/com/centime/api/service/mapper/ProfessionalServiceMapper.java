
package com.centime.api.service.mapper;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.centrum.model.ProfessionalIdResponse;

/**
 * @author jmahajan
 *
 */
@Component
public class ProfessionalServiceMapper implements Converter<Map.Entry<String, List<String>>, ProfessionalIdResponse> {

	@Override
	public ProfessionalIdResponse convert(Entry<String, List<String>> source) {
		ProfessionalIdResponse professionalIdResponse = new ProfessionalIdResponse();
		professionalIdResponse.setName(source.getKey());
		professionalIdResponse.setSubProfession(source.getValue());
		return professionalIdResponse;
	}

}
