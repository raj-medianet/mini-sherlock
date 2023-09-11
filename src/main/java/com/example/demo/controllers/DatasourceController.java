package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.DatasourceNotFoundException;
import com.example.demo.models.Datasource;
import com.example.demo.services.DatasourceService;

import jakarta.validation.Valid;

@RestController
public class DatasourceController {

	private final DatasourceService datasourceService;

	@Autowired
	public DatasourceController(DatasourceService datasourceService) {
		this.datasourceService = datasourceService;
	}
	
	@GetMapping("/datasources/{datasourceName}")
	public ResponseEntity<Datasource> getDatasource(@PathVariable String datasourceName) throws DatasourceNotFoundException{
		Datasource datasource = datasourceService.getDatasource(datasourceName);
		return new ResponseEntity<>(datasource, HttpStatus.OK);
	}

	@PostMapping("/datasources")
	public ResponseEntity<Datasource> addDatasource(@RequestBody @Valid Datasource datasource) {
		Datasource savedDatasource = datasourceService.addDatasource(datasource);
		return new ResponseEntity<>(savedDatasource, HttpStatus.CREATED);
	}

	@DeleteMapping("/datasources/{datasourceName}")
	public void deleteDatasource(@PathVariable String datasourceName) throws DatasourceNotFoundException{
		datasourceService.deleteDatasource(datasourceName);
	}

}
