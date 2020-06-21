package com.centime.api.service.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centrum.model.ConcentatedWordResponse;
import com.centrum.model.WordResponse;

/**
 * @author jmahajan
 *
 */
@RestController
public class WordAPIController implements WordAPI {

	private static final Logger LOG = LogManager.getLogger(WordAPIController.class);

	@Override
	public ResponseEntity<WordResponse> retrieveWord() {
		LOG.trace("retrieve single word starts");
		WordResponse wordResponse = new WordResponse();
		wordResponse.setMessage("Hello");
		LOG.trace("retrieve single word ends");
		return new ResponseEntity<>(wordResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ConcentatedWordResponse> getConcateWord() {
		LOG.trace("getConcateWord starts");
		ConcentatedWordResponse concentatedWordResponse = new ConcentatedWordResponse();
		concentatedWordResponse.setName("John");
		concentatedWordResponse.setSurname("Doe");
		LOG.trace("getConcateWord ends");
		return new ResponseEntity<>(concentatedWordResponse, HttpStatus.OK);
	}

}
