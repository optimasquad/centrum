
package com.centime.api.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.centime.api.service.entity.Profession;
import com.centime.api.service.mapper.ProfessionalServiceMapper;
import com.centime.api.service.repository.ProfessionRepository;
import com.centime.api.service.service.impl.ProfessionalAPIServiceImpl;
import com.centrum.model.AllProfessionsResponse;
import com.centrum.model.ProfessionalIdResponse;

/**
 * @author jmahajan
 *
 */
public class ProfessionalAPIServiceImplTest {

	@Mock
	private ProfessionRepository professionRepository;

	@Mock
	private ProfessionalServiceMapper professionalServiceMapper;

	@InjectMocks
	private ProfessionalAPIServiceImpl professionalAPIService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllProfessions() {
		Profession profession = new Profession();
		profession.setId(123l);
		profession.setName("warrior");
		profession.setParentid(123l);

		Profession profession2 = new Profession();
		profession2.setId(123l);
		profession2.setName("ranger");
		profession2.setParentid(0l);

		Profession profession3 = new Profession();
		profession3.setId(123l);
		profession3.setName("stigma");
		profession3.setParentid(123l);

		List<Profession> professionList = new ArrayList<>();
		professionList.add(profession3);
		professionList.add(profession2);
		professionList.add(profession);

		Mockito.when(professionRepository.findAll()).thenReturn(professionList);

		List<String> subProfession = new ArrayList<>();
		subProfession.add("ranger");

		Map<String, List<String>> professionals = new HashMap<>();
		professionals.put("warrior", subProfession);

		ProfessionalIdResponse professionalIdResponse = new ProfessionalIdResponse();
		professionalIdResponse.setName("warrior");
		professionalIdResponse.setSubProfession(subProfession);

		Mockito.when(professionalServiceMapper.convert(any())).thenReturn(professionalIdResponse);

		AllProfessionsResponse allProfessionsResponse = professionalAPIService.getAllProfessions();
		assertNotNull(allProfessionsResponse);
		assertEquals("warrior", allProfessionsResponse.get(0).getName());
		assertEquals("ranger", allProfessionsResponse.get(0).getSubProfession().get(0));

	}

	@Test
	public void testGetProfessionFromId() {
		Profession profession = new Profession();
		profession.setId(123l);
		profession.setName("warrior");
		profession.setParentid(123l);

		Optional<Profession> professionOpt = Optional.of(profession);

		Mockito.when(professionRepository.findById(123l)).thenReturn(professionOpt);

		final Set<Profession> professionList = new HashSet<>();
		professionList.add(profession);

		Mockito.when(professionRepository.findByParentid(1234l)).thenReturn(professionList);

		ProfessionalIdResponse professionalIdResponse = new ProfessionalIdResponse();
		professionalIdResponse.setName("warrior");

		List<String> subProfession = new ArrayList<>();
		subProfession.add("ranger");
		professionalIdResponse.setSubProfession(subProfession);

		Map<String, List<String>> professionals = new HashMap<>();
		professionals.put("warrior", subProfession);

		Mockito.when(professionalServiceMapper.convert(any())).thenReturn(professionalIdResponse);

		ProfessionalIdResponse professionalIdFinalResponse = professionalAPIService.getProfessionFromId(123l);
		assertNotNull(professionalIdFinalResponse);
		assertEquals("warrior", professionalIdFinalResponse.getName());
		assertEquals("ranger", professionalIdFinalResponse.getSubProfession().get(0));
	}

}
