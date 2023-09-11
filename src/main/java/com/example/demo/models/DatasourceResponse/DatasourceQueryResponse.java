package com.example.demo.models.DatasourceResponse;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class DatasourceQueryResponse {

	ArrayList<DatasourceTimeseriesResult> result = new ArrayList<>();
	private String error = null;
	private boolean isValid;

}
