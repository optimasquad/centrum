package com.centime.api.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centrum.model.SucessResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-21T07:16:38.587Z")

@Api(value = "health", description = "the health API")
@RequestMapping(value = "/v1")
public interface HealthAPI {

    @ApiOperation(value = "Checking the health check of the api", nickname = "getHealth", notes = "Checking the health check of the api", response = SucessResponse.class, tags={ "health", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "healh of api", response = SucessResponse.class),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 403, message = "Permission denied") })
    @RequestMapping(value = "/health",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<SucessResponse> getHealth();

}
