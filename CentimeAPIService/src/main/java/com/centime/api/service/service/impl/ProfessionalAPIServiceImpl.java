
package com.centime.api.service.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centime.api.entity.Profession;
import com.centime.api.repository.ProfessionRepository;
import com.centime.api.service.service.ProfessionalAPIService;
import com.centrum.model.AllProfessionsResponse;
import com.centrum.model.ProfessionalIdResponse;

/**
 * @author jmahajan
 *
 */
@Service
public class ProfessionalAPIServiceImpl implements ProfessionalAPIService {

	@Autowired
	private ProfessionRepository professionRepository;

	@Override
	public ProfessionalIdResponse getProfessionFromId(Long id) {
		Optional<Profession> professionResult = professionRepository.findById(id);
		System.out.println(professionResult);
		return null;
	}

	@Override
	public AllProfessionsResponse getAllProfessions() {
		// TODO Auto-generated method stub
		return null;
	}

}
