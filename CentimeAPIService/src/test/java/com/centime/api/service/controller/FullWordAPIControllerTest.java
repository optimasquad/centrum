
package com.centime.api.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.centime.api.service.CentimeAPIApplicationTest;
import com.centime.api.service.service.FullWordAPIService;
import com.centrum.model.FullConcentatedWordResponse;

/**
 * @author jmahajan
 *
 */
public class FullWordAPIControllerTest extends CentimeAPIApplicationTest {

	@Mock
	private FullWordAPIService fullWordAPIService;

	@InjectMocks
	private FullWordAPIController fullWordAPIController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(fullWordAPIController).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveFullConcentatedWord() throws Exception {

		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/fullWord"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		FullConcentatedWordResponse fullConcentatedWordResponse = new FullConcentatedWordResponse();
		fullConcentatedWordResponse.setFullWord("Hello");

		when(fullWordAPIService.retrieveFullConcentatedWord()).thenReturn(fullConcentatedWordResponse);

		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		assertEquals("Hello", fullConcentatedWordResponse.getFullWord());

	}

}
