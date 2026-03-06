package com.customer_service.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customer_service.api.entity.Region;
import com.customer_service.api.repository.RepoRegion;
import com.customer_service.exception.ApiException;
import com.customer_service.exception.DBAccessException;

@Service
public class SvcRegionImp implements SvcRegion {

	@Autowired
	RepoRegion repo;

	@Override
	public List<Region> findAll() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw new ApiException(HttpStatus.CONFLICT, "El nombre de la región ya "
					+ "está registrado");
		}
	}

	@Override
	public List<Region> findActive() {
		try {
			return repo.findActive();
		}catch(DataAccessException e) {
			throw new DBAccessException(e);
//			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Error"
//					+ " al acceder a la base de datos");
		}
	}

}
