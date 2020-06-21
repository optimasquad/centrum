package com.centime.api.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centrum.model.WordResponse;

/**
 * @author jmahajan
 *
 */
@RestController
public class WordAPIController implements WordAPI {

	/**
	 *
	 */
	@Override
	public ResponseEntity<WordResponse> retrieveWord() {
		WordResponse wordResponse = new WordResponse();
		wordResponse.setMessage("Hello");
		return new ResponseEntity<>(wordResponse, HttpStatus.OK);
	}

}
