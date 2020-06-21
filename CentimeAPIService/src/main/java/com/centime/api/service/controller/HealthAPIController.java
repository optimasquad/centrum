
package com.centime.api.service.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centrum.model.SucessResponse;

/**
 * @author jmahajan
 *
 */
@RestController
public class HealthAPIController implements HealthAPI {

	private static final Logger LOG = LogManager.getLogger(HealthAPIController.class);

	@Override
	public ResponseEntity<SucessResponse> getHealth() {
		LOG.info("get heath status starts");
		SucessResponse sucessResponse = new SucessResponse();
		sucessResponse.setMessage("Up");
		LOG.info("get heath status ends");
		return new ResponseEntity<>(sucessResponse, HttpStatus.OK);
	}

}
