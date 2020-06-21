
package com.centime.api.service.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger LOG = LogManager.getLogger(FullWordAPIController.class);

	@Autowired
	private FullWordAPIService fullWordAPIService;

	@Override
	public ResponseEntity<FullConcentatedWordResponse> retrieveFullConcentatedWord() {
		LOG.trace("Retrieve Full Concatenated word starts");
		FullConcentatedWordResponse fullConcentatedWordResponse = fullWordAPIService.retrieveFullConcentatedWord();
		LOG.trace("Retrieve Full Concatenated word ends");
		return new ResponseEntity<>(fullConcentatedWordResponse, HttpStatus.OK);
	}

}
