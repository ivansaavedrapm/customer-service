package com.customer_service.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer_service.api.entity.Region;

@RestController
@RequestMapping("/region")
public class CtrlRegion {
	
	@GetMapping
	public List<Region> getRegions() {
		List<Region> regions = regionList();
		return regions;
	}
	
	@GetMapping("/{id}")
	public Region getRegion(@PathVariable Integer id) {
		List<Region> regions = regionList();
		
		for(int i=0; i<regions.size(); i++) {
			if(regions.get(i).getRegion_id() == id)
				return regions.get(i);
		}
		
		return null;
	}
	
	private List<Region> regionList(){
		List<Region> regions = new ArrayList<Region>();
		regions.add(new Region(1,"Norte","N",1));
		regions.add(new Region(2,"Sur","S",1));
		regions.add(new Region(3,"Este","E",0));
		return regions;
	}

}
