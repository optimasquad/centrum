
package com.centime.api.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centrum.model.ConcentatedWordResponse;
import com.centrum.model.WordResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author jmahajan
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-21T07:16:38.587Z")

@Api(value = "word", description = "the word API")
@RequestMapping(value = "/v1")
public interface WordAPI {

	@ApiOperation(value = "Retrieve the word from the api", nickname = "getConcateWordWord", notes = "Retrieve the word from the api", response = ConcentatedWordResponse.class, tags = {
			"words", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "retrieve word of the api", response = ConcentatedWordResponse.class),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Permission denied") })
	@RequestMapping(value = "/word", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<ConcentatedWordResponse> getConcateWord();

	@ApiOperation(value = "Retrieve the word from the api", nickname = "retrieveWord", notes = "Retrieve the word from the api", response = WordResponse.class, tags = {
			"words", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "retrieve word of the api", response = WordResponse.class),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Permission denied") })
	@RequestMapping(value = "/word", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<WordResponse> retrieveWord();
}
