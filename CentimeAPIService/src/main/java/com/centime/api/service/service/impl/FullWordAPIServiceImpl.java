
package com.centime.api.service.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centime.api.service.service.FullWordAPIService;
import com.centrum.ApiClient;
import com.centrum.api.WordsApi;
import com.centrum.model.ConcentatedWordResponse;
import com.centrum.model.FullConcentatedWordResponse;
import com.centrum.model.WordResponse;

/**
 * @author jmahajan
 *
 */
@Service
public class FullWordAPIServiceImpl implements FullWordAPIService {

	private static final String USERNAME = "test";
	private static final String PASSWORD = "test";

	@Autowired
	private WordsApi wordsApi;

	@Autowired
	private ApiClient apiClient;

	@PostConstruct
	protected void setUp() {
		apiClient.setUsername(USERNAME);
		apiClient.setPassword(PASSWORD);
	}

	@Override
	public FullConcentatedWordResponse retrieveFullConcentatedWord() {
		// First API
		WordResponse wordresponse = wordsApi.retrieveWord();
		// Second API
		ConcentatedWordResponse concentatedWordResponse = wordsApi.getConcateWord();

		FullConcentatedWordResponse fullConcentatedWordResponse = new FullConcentatedWordResponse();

		String finalResponse = wordresponse.getMessage() + concentatedWordResponse.getName()
				+ concentatedWordResponse.getSurname();
		fullConcentatedWordResponse.setFullWord(finalResponse);

		return fullConcentatedWordResponse;
	}

}
