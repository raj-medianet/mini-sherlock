package com.example.demo.monitorService;

import com.example.demo.models.Datasource;

@FunctionalInterface
public interface MonitorService<T> {
	
	public T monitorDatasource(Datasource datasource, String startTime, String endTime,
			String granularity);
	
}
