package com.customer_service.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customer_service.api.dto.DtoCustomerIn;
import com.customer_service.api.dto.DtoCustomerListOut;
import com.customer_service.api.dto.DtoCustomerOut;
import com.customer_service.api.repository.RepoCustomer;
import com.customer_service.exception.ApiException;
import com.customer_service.exception.DBAccessException;

@Service
public class SvcCustomerImp implements SvcCustomer {
	
	@Autowired
	RepoCustomer repo;
	
	@Value("${app.upload.dir}")
	private String uploadDir;
	
	@Value("${app.upload.images}")
	private String uploadImages;

	@Override
	public List<DtoCustomerListOut> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtoCustomerOut findById(Integer id) {
		try {
			
			// 1. Consultar los datos del cliente de la DB
			
			DtoCustomerOut customer = repo.getCustomer(id);
			
			if(customer == null)
				throw new ApiException(HttpStatus.NOT_FOUND, "El id del cliente no existe");
			
			// 2. Leer la imagen del sistema de archivos
			
			String imageUrl = customer.getImage();
			
			// Si la URL comienza con "/" la eliminamos para obtener la ruta relativa
		  	 if (imageUrl.startsWith("/")) {
		       	    imageUrl = imageUrl.substring(1);
		   	}
		  
		  	 // Construir el Path
		  	 Path imagePath = Paths.get(uploadDir, uploadImages, imageUrl);
		  
		  	 // Verifica que el archivo exista
		   	if (!Files.exists(imagePath)) {
		   		customer.setImage(null);
		   	    return customer;
		   	}
		   	
		   	// 3. Convertir la imagen a Base64
		  
			// Leer los bytes de la imagen y codificarlos a Base64
			byte[] imageBytes = Files.readAllBytes(imagePath);
			customer.setImage(Base64.getEncoder().encodeToString(imageBytes));
			
			// 4. Devolvemos todos los datos del cliente
			
			return customer;
			
		} catch (DataAccessException e) {
			throw new DBAccessException();
		} catch (IOException e) {
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al leer el archivo");
	    }

	}

	@Override
	public void create(DtoCustomerIn in) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Integer id, DtoCustomerIn in) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enable(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disable(Integer id) {
		// TODO Auto-generated method stub

	}

}
