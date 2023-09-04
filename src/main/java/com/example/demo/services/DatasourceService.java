package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DatasourceRepository;
import com.example.demo.models.Datasource;

@Service
public class DatasourceService {

	@Autowired
	DatasourceRepository datasourceRepository;

	public Datasource getDatasource(String datasourceName) {
		return datasourceRepository.findById(datasourceName).orElse(null);
	}

	public Datasource addDatasource(Datasource datasource) {
		return datasourceRepository.save(datasource);
	}

	public boolean deleteDatasource(String datasourceName) {
		Datasource datasource = datasourceRepository.findById(datasourceName).orElse(null);
		if (datasource == null)
			return false;
		else
			datasourceRepository.delete(datasource);
		return true;
	}

}
