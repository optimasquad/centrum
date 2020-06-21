
package com.centime.api.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centime.api.service.service.FullWordAPIService;
import com.centrum.model.FullConcentatedWordResponse;

/**
 * @author jmahajan
 *
 */
@RestController
public class FullWordAPIController implements FullWordAPI {

	@Autowired
	private FullWordAPIService fullWordAPIService;

	@Override
	public ResponseEntity<FullConcentatedWordResponse> retrieveFullConcentatedWord() {

		FullConcentatedWordResponse fullConcentatedWordResponse = fullWordAPIService.retrieveFullConcentatedWord();
		return new ResponseEntity<>(fullConcentatedWordResponse, HttpStatus.OK);
	}

}
