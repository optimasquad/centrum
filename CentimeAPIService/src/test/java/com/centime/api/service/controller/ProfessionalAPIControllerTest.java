
package com.centime.api.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.centime.api.service.service.ProfessionalAPIService;
import com.centrum.model.AllProfessionsResponse;
import com.centrum.model.ProfessionalIdResponse;

/**
 * @author jmahajan
 *
 */
public class ProfessionalAPIControllerTest {

	@Mock
	private ProfessionalAPIService professionalAPIService;

	@InjectMocks
	private ProfessionAPIController professionalAPIController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(professionalAPIController).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllProfessions() throws Exception {

		AllProfessionsResponse allProfessionsResponse = new AllProfessionsResponse();
		ProfessionalIdResponse professionalIdResponse = new ProfessionalIdResponse();
		professionalIdResponse.setName("test");
		allProfessionsResponse.add(professionalIdResponse);

		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getAllProfessions"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		Mockito.when(professionalAPIService.getAllProfessions()).thenReturn(allProfessionsResponse);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals("test", allProfessionsResponse.get(0).getName());
	}

	@Test
	public void testGetProfessionFromId() throws Exception {

		ProfessionalIdResponse professionalIdResponse = new ProfessionalIdResponse();
		professionalIdResponse.setName("test");

		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/profession/1234"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		Mockito.when(professionalAPIService.getProfessionFromId(223l)).thenReturn(professionalIdResponse);
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals("test", professionalIdResponse.getName());
	}

}
