package com.customer_service.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer_service.api.dto.DtoCustomerOut;
import com.customer_service.api.service.SvcCustomer;

@RestController
@RequestMapping("/customer")
public class CtrlCustomer {

	@Autowired
	SvcCustomer svc;
	
	@GetMapping("/{id}")
	public ResponseEntity<DtoCustomerOut> getCustomer(@PathVariable Integer id){
		return ResponseEntity.ok(svc.findById(id));
	}
}
