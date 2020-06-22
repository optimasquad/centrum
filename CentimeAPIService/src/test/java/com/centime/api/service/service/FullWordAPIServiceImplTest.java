
package com.centime.api.service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Base64;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.centime.api.service.service.impl.FullWordAPIServiceImpl;
import com.centrum.ApiClient;
import com.centrum.api.WordsApi;
import com.centrum.model.ConcentatedWordResponse;
import com.centrum.model.FullConcentatedWordResponse;
import com.centrum.model.WordResponse;

/**
 * @author jmahajan
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Base64.class })
public class FullWordAPIServiceImplTest {

	@Mock
	private WordsApi wordsApi;

	@Mock
	private ApiClient apiClient;

	@InjectMocks
	private FullWordAPIServiceImpl fullWordAPIService;

	@Before
	public void setUp() {
		PowerMockito.mockStatic(Base64.class);
		Mockito.when(apiClient.getBasePath()).thenReturn("localhost:8080");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveFullConcentatedWord() {
		WordResponse wordresponse = new WordResponse();
		wordresponse.setMessage("Hello");
		Mockito.when(wordsApi.retrieveWord()).thenReturn(wordresponse);

		ConcentatedWordResponse concentatedWordResponse = new ConcentatedWordResponse();
		concentatedWordResponse.setName("John");
		concentatedWordResponse.setSurname("Doe");

		Mockito.when(wordsApi.getConcateWord()).thenReturn(concentatedWordResponse);

		FullConcentatedWordResponse fullConcentatedWordResponse = fullWordAPIService.retrieveFullConcentatedWord();
		assertNotNull(fullConcentatedWordResponse);
		assertEquals("Hello John Doe", fullConcentatedWordResponse.getFullWord());
	}

}
