package com.centime.api.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centrum.model.AllProfessionsResponse;
import com.centrum.model.ProfessionalIdResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ProfessionAPI {

	@ApiOperation(value = "Retrieve all professions", nickname = "getAllProfessions", notes = "Retrieve all professions", response = AllProfessionsResponse.class, tags = {
			"profession", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "retrieve all professions", response = AllProfessionsResponse.class),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Permission denied") })
	@RequestMapping(value = "/profession", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<AllProfessionsResponse> getAllProfessions();

	@ApiOperation(value = "Retrieve profession on basis of id", nickname = "getProfessionFromId", notes = "Retrieve profession on basis of id", response = ProfessionalIdResponse.class, tags = {
			"profession", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "retrieve profession on basis of id", response = ProfessionalIdResponse.class),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Permission denied") })
	@RequestMapping(value = "/profession/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ProfessionalIdResponse> getProfessionFromId(
			@ApiParam(value = "Unique id", required = true) @PathVariable("id") Long id);
}
