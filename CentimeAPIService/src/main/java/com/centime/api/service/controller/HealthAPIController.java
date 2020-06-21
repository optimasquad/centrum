
package com.centime.api.service.controller;

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

	@Override
	public ResponseEntity<SucessResponse> getHealth() {
		SucessResponse sucessResponse = new SucessResponse();
		sucessResponse.setMessage("Up");
		return new ResponseEntity<>(sucessResponse, HttpStatus.OK);
	}

}
