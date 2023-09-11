package com.example.demo.models.DatasourceResponse;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DatasourceTimeseriesResult {

	@JsonProperty("Timestamp")
	String timestamp;
	private Map<String, Double> metrics = new HashMap<>();

	public String getTimestamp() {
		return timestamp;
	}

	@JsonAnySetter
	public void addMetric(String key, Double value) {
		this.metrics.put(key, value);
	}

	@JsonAnyGetter
	public Map<String, Double> getMetrics() {
		return metrics;
	}
}
