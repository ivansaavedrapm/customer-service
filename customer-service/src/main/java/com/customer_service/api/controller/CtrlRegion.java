package com.customer_service.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer_service.api.dto.DtoRegionIn;
import com.customer_service.api.entity.Region;
import com.customer_service.api.repository.RepoRegion;
import com.customer_service.api.service.SvcRegion;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/region")
public class CtrlRegion {
	
	@Autowired
	SvcRegion svc;
	
	@Autowired
	RepoRegion repo;
	
	@GetMapping
	public ResponseEntity<List<Region>> findAll() {
//		return new ResponseEntity<>(svc.findAll(), HttpStatus.OK);
		return ResponseEntity.ok(svc.findAll());
	}
	
	@GetMapping("/active")
	public ResponseEntity<List<Region>> findActive() {
//		return ResponseEntity.ok(svc.findActive());
		return ResponseEntity.ok(repo.findByStatusOrderByRegionAsc(1));
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody DtoRegionIn in){
//		svc.create(in);
		repo.create(in.getRegion(), in.getTag());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody DtoRegionIn in, 
			@PathVariable Integer id){
//		svc.update(in, id);
		repo.update(id, in.getRegion(), in.getTag());
		
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{id}/enable")
	public ResponseEntity<Void> enable(@PathVariable Integer id){
//		svc.enable(id);
//		svc.switchStatus(id, 1);
		
//		repo.enable(id);
		repo.switchStatus(id, 1);
		
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{id}/disable")
	public ResponseEntity<Void> disable(@PathVariable Integer id){
//		svc.disable(id);
//		svc.switchStatus(id, 0);
		
//		repo.disable(id);
		repo.switchStatus(id, 0);
		
		return ResponseEntity.ok().build();
	}
	
}
