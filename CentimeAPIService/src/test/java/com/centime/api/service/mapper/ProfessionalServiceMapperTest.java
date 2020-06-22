
package com.centime.api.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.centrum.model.ProfessionalIdResponse;

/**
 * @author jmahajan
 *
 */
public class ProfessionalServiceMapperTest {

	private ProfessionalServiceMapper professionalServiceMapper = null;

	@Test
	public void testConvert() {
		professionalServiceMapper = new ProfessionalServiceMapper();

		Map<String, List<String>> map = new HashMap<>();

		List<String> subClass = new ArrayList<>();
		subClass.add("Ranger");
		map.put("warrior", subClass);

		ProfessionalIdResponse professionalIdResponse = professionalServiceMapper
				.convert(map.entrySet().iterator().next());
		assertNotNull(professionalIdResponse);
		assertEquals("warrior", professionalIdResponse.getName());
		assertEquals("Ranger", professionalIdResponse.getSubProfession().get(0));
	}

}
