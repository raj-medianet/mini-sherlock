package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.example.demo.datasourceQueryRequestPayload.KonomPayload;
import com.example.demo.exception.DatasourceNotFoundException;
import com.example.demo.models.DatasourceResponse.DatasourceQueryResponse;
import com.example.demo.services.DatasourceService;
import com.example.demo.services.MonitorDatasource;

import jakarta.validation.constraints.Min;

@Validated
@RequestMapping("/datasources/monitor")
@RestController
public class MonitorDatasourceController {

	private final DatasourceService datasourceService;
	private final MonitorDatasource monitorDatasource;

	@Autowired
	public MonitorDatasourceController(DatasourceService datasourceService, MonitorDatasource monitorDatasource) {
		this.datasourceService = datasourceService;
		this.monitorDatasource = monitorDatasource;
	}

	@GetMapping("/konom")
	public ResponseEntity<DatasourceQueryResponse> monitorKonom(@RequestParam String tableName,
			@RequestParam String metricsName, @RequestParam @Min(5) long granularity, @RequestParam double threshold,
			@RequestParam boolean drop, @RequestHeader("X-KONOM-GROUPS") String group,
			@RequestHeader("X-AUTH-TOKEN") String authToken, @RequestHeader("X-KONOM-USER") String user)
			throws DatasourceNotFoundException, ResourceAccessException {

		KonomPayload konomPayload = new KonomPayload(tableName, metricsName, granularity);

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-KONOM-USER", user);
		headers.add("X-KONOM-GROUPS", group);
		headers.add("X-AUTH-TOKEN", authToken);
		headers.setContentType(MediaType.APPLICATION_JSON);

		DatasourceQueryResponse response = monitorDatasource.monitor(datasourceService.getDatasource("konom"),
				konomPayload, headers, threshold, drop);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// add new datasource monitor endpoint here
}
