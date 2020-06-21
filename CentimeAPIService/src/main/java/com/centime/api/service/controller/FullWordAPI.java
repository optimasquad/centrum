package com.centime.api.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centrum.model.FullConcentatedWordResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author jmahajan
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-21T08:07:55.292Z")

@Api(value = "fullWord", description = "the fullWord API")
@RequestMapping(value = "/v1")
public interface FullWordAPI {

	@ApiOperation(value = "Retrieve final words response from the api's that are word api and concatenant word api", nickname = "retrieveFullConcentatedWord", notes = "Retrieve full concatenated words response from the api", response = FullConcentatedWordResponse.class, tags = {
			"words", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "retrieve full concatenated word of the api", response = FullConcentatedWordResponse.class),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Permission denied") })
	@RequestMapping(value = "/fullWord", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<FullConcentatedWordResponse> retrieveFullConcentatedWord();

}
