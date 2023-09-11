package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DatasourceNotFoundException;
import com.example.demo.models.Datasource;
import com.example.demo.repository.DatasourceRepository;

@Service
public class DatasourceService {

	@Autowired
	DatasourceRepository datasourceRepository;

	public Datasource getDatasource(String datasourceName) throws DatasourceNotFoundException{
		Datasource datasource = datasourceRepository.findById(datasourceName).orElse(null);
		if(datasource!=null)
			return datasource;
		else
			throw new DatasourceNotFoundException("Datasource not found: "+datasourceName);
	}

	public Datasource addDatasource(Datasource datasource) {
		return datasourceRepository.save(datasource);
	}

	public boolean deleteDatasource(String datasourceName) throws DatasourceNotFoundException{
		Datasource datasource = datasourceRepository.findById(datasourceName).orElse(null);
		if (datasource == null)
			throw new DatasourceNotFoundException("Datasource not found: "+datasourceName);
		else
			datasourceRepository.delete(datasource);
		return true;
	}

}
