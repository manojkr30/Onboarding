package com.cv2.onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cv2.onboarding.entity.AddressDetails;
import com.cv2.onboarding.entity.EntityDetails;
import com.cv2.onboarding.service.OnboardingService;
import com.cv2.onboarding.util.EntityStatus;
import com.cv2.onboarding.util.Response;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/api/vendor/v1")
public class OnboardingController {

	private OnboardingService onboardingService;
	
     @Autowired
	public OnboardingController(OnboardingService onboardingService) {
		this.onboardingService = onboardingService;
	}

	@PostMapping
	public ResponseEntity<Response> registerEntity(@RequestBody EntityDetails entity ){
		return new ResponseEntity<Response>(Response.builder().data(onboardingService.registerEntity(entity))
				.statusCode(HttpStatus.CREATED.value()).statusMsg("Data Stored Successfully .").build(),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getEntityById(@PathVariable("id") Integer id){
		return new ResponseEntity<Response>(Response.builder().data(onboardingService.getEntityById(id)).statusCode(HttpStatus.FOUND.value()).statusMsg("Vendor Successfully Featch from data base by id "+ id).build(),HttpStatus.FOUND);
	}

	@GetMapping
	public ResponseEntity<Response> getAllEntitys(){
		return new ResponseEntity<Response>(Response.builder().datas(onboardingService.getAllEntitys()).statusCode(HttpStatus.FOUND.value()).statusMsg("All Vendors Successfully Featched from Data Base .").build(),HttpStatus.FOUND);
	}

	@PutMapping
	public ResponseEntity<Response> updateEntity( @RequestBody EntityDetails entity) {
		return new ResponseEntity<Response>(Response.builder().data(onboardingService.updateEntity(entity)).statusCode(HttpStatus.OK.value()).statusMsg("Vendor Successfully Updated .").build(),HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> updateEntityStatus( @PathVariable("id") Integer id,@RequestParam  EntityStatus status) {
		return new ResponseEntity<Response>(Response.builder().data(onboardingService.updateEntityStatus(id,status)).statusCode(HttpStatus.OK.value()).statusMsg("Status Successfully Seted to Vendor .").build(),HttpStatus.OK);
	}

}
