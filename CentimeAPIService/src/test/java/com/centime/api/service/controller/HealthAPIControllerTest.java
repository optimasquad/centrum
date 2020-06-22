
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

/**
 * @author jmahajan
 *
 */
public class HealthAPIControllerTest {

	@InjectMocks
	private HealthAPIController healthAPIController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(healthAPIController).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetHealth() throws Exception {

		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/health"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

	}

}
