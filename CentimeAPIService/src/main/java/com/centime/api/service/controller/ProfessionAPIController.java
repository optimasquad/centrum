package com.centime.api.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centime.api.service.service.ProfessionalAPIService;
import com.centrum.model.AllProfessionsResponse;
import com.centrum.model.ProfessionalIdResponse;

@RestController
public class ProfessionAPIController implements ProfessionAPI {

	@Autowired
	private ProfessionalAPIService professionalAPIService;

	@Override
	public ResponseEntity<AllProfessionsResponse> getAllProfessions() {
		AllProfessionsResponse allProfessionsResponse = professionalAPIService.getAllProfessions();
		return new ResponseEntity<>(allProfessionsResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProfessionalIdResponse> getProfessionFromId(Long id) {
		ProfessionalIdResponse professionalIdResponse = professionalAPIService.getProfessionFromId(id);
		return new ResponseEntity<>(professionalIdResponse, HttpStatus.OK);
	}

}
