
package com.centime.api.service.service.impl;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger LOG = LogManager.getLogger(FullWordAPIService.class);

	@Autowired
	private WordsApi wordsApi;

	@Autowired
	private ApiClient apiClient;

	@PostConstruct
	protected void setUp() {
		apiClient.setBasePath(apiClient.getBasePath().replace("localhost", "localhost:8080"));
		LOG.info("API Base Path {}", apiClient.getBasePath());
	}

	@Override
	public FullConcentatedWordResponse retrieveFullConcentatedWord() {
		// First API
		WordResponse wordresponse = wordsApi.retrieveWord();
		// Second API
		ConcentatedWordResponse concentatedWordResponse = wordsApi.getConcateWord();

		FullConcentatedWordResponse fullConcentatedWordResponse = new FullConcentatedWordResponse();

		StringBuilder builder = new StringBuilder();
		builder.append(wordresponse.getMessage()).append(" ").append(concentatedWordResponse.getName()).append(" ")
				.append(concentatedWordResponse.getSurname());

		fullConcentatedWordResponse.setFullWord(builder.toString());

		return fullConcentatedWordResponse;
	}

}
