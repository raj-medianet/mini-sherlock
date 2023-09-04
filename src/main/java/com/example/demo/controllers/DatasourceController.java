package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Datasource;
import com.example.demo.models.konomResponse.KonomResponse;
import com.example.demo.monitorService.MonitorKonom;
import com.example.demo.services.DatasourceService;

@RestController
public class DatasourceController {

	private final DatasourceService datasourceService;
	@Autowired
	private final MonitorKonom monitorKonom;

	@Autowired
	public DatasourceController(DatasourceService datasourceService,
			MonitorKonom monitorKonom) {
		this.datasourceService = datasourceService;
		this.monitorKonom = monitorKonom;
	}

	@PostMapping("/datasources")
	public ResponseEntity<Datasource> addDatasource(@RequestBody Datasource datasource) {
		datasourceService.addDatasource(datasource);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/datasources/{datasourceName}")
	public void deleteDatasource(@PathVariable String datasourceName) {
		datasourceService.deleteDatasource(datasourceName);
	}

	@PostMapping("/datasources/{datasourceName}/monitor")
	public KonomResponse monitorDatasource(@PathVariable String datasourceName, @RequestParam String startTime,
			@RequestParam String endTime, @RequestParam String granularity) {
		Datasource datasource = datasourceService.getDatasource(datasourceName);
		return monitorKonom.monitorDatasource(datasource, startTime, endTime, granularity);
	}

}
