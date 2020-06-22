
package com.centime.api.service.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centime.api.service.entity.Profession;
import com.centime.api.service.mapper.ProfessionalServiceMapper;
import com.centime.api.service.repository.ProfessionRepository;
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

	@Autowired
	private ProfessionalServiceMapper professionalServiceMapper;

	@Override
	public ProfessionalIdResponse getProfessionFromId(Long id) {
		ProfessionalIdResponse professionalIdResponse = null;
		Optional<Profession> professionResult = professionRepository.findById(id);
		Map<String, List<String>> professionMap = new HashMap<>();
		if (professionResult.isPresent()) {
			// findByParentId
			Set<Profession> subProfessions = professionRepository.findByParentid(id);
			List<String> subProfessionNames = subProfessions.stream().map(Profession::getName)
					.collect(Collectors.toList());

			professionMap.put(professionResult.get().getName(), subProfessionNames);

			professionalIdResponse = professionMap.entrySet().stream().map(professionalServiceMapper::convert).findAny()
					.get();
		}
		return professionalIdResponse;
	}

	@Override
	public AllProfessionsResponse getAllProfessions() {
		List<Profession> allResults = (List<Profession>) professionRepository.findAll();

		// Filter the results to get the parent id
		List<Profession> resultProfessions = allResults.stream().filter(p -> p.getParentid() == 0)
				.collect(Collectors.toList());

		Map<String, List<String>> professionMap = new HashMap<>();
		for (Profession profession : resultProfessions) {
			// get All the Professions with same id
			List<String> subListOfProfession = allResults.stream().filter(p -> p.getParentid() == profession.getId())
					.map(Profession::getName).collect(Collectors.toList());
			professionMap.put(profession.getName(), subListOfProfession);
		}

		List<ProfessionalIdResponse> professionalIdResponses = professionMap.entrySet().stream()
				.map(professionalServiceMapper::convert).collect(Collectors.toList());
		AllProfessionsResponse allProfessionsResponse = new AllProfessionsResponse();
		allProfessionsResponse.addAll(professionalIdResponses);
		return allProfessionsResponse;
	}

}
