
package com.centime.api.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.centime.api.service.CentimeAPIApplicationTest;

/**
 * @author jmahjan
 *
 */
public class WordAPIControllerTest extends CentimeAPIApplicationTest {

	@InjectMocks
	private WordAPIController wordAPIController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(wordAPIController).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveWord() throws Exception {
		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/word"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

	}

	@Test
	public void testGetConcateWord() throws Exception {
		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/word"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

	}

}
