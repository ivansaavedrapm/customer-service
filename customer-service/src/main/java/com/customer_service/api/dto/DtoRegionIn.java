package com.customer_service.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class DtoRegionIn {

	@JsonProperty("region")
	@NotNull(message="La región es obligatoria")
	private String region;
		
	@JsonProperty("tag")
	@NotNull(message="El tag es obligatorio")
	private String tag;
}
