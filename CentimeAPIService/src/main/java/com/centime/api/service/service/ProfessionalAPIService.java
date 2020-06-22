
package com.centime.api.service.service;

import com.centrum.model.AllProfessionsResponse;
import com.centrum.model.ProfessionalIdResponse;

/**
 * @author jmahajan
 *
 */
public interface ProfessionalAPIService {

	public ProfessionalIdResponse getProfessionFromId(Long id);

	public AllProfessionsResponse getAllProfessions();

}
