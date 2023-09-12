package com.example.demo.services;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.datasourceQueryRequestPayload.DatasourceQuerypayload;
import com.example.demo.models.Datasource;
import com.example.demo.models.DatasourceResponse.DatasourceQueryResponse;
import com.example.demo.models.DatasourceResponse.DatasourceTimeseriesResult;

@Service
public class MonitorDatasource {

	public DatasourceQueryResponse monitor(Datasource datasource, DatasourceQuerypayload payload, HttpHeaders headers,
			double threshold, boolean drop) throws ResourceAccessException {

		String datasourceUrl = datasource.getUrl();

		String requestBody = payload.generatePayload();
		System.out.println("req body:\n" + requestBody);
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
		DatasourceQueryResponse response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.postForObject(datasourceUrl, requestEntity, DatasourceQueryResponse.class);
		} catch (ResourceAccessException e1) {
			throw new ResourceAccessException("Datasource " + datasource.getName() + " is unavailable.");
		}

		if (response != null) {
			System.out.println("Total Datapoints: " + response.getResult().size());
			sendAlert(response.getResult(), payload.getCustomMeasureOutputName(), threshold, drop);
		}
		return response;
	}

	private void sendAlert(List<DatasourceTimeseriesResult> result, String customMeasureOutputName, double threshold,
			boolean drop) {
		for (DatasourceTimeseriesResult r : result) {
			double currentDatapoint = r.getMetrics().get(customMeasureOutputName);
			if (drop) {
				if (currentDatapoint < threshold) {
					System.out.println("Alert:\n Output:" + r.getMetrics() + " \n Timestamp: " + r.getTimestamp() + "\n");
					calculateDeviation(currentDatapoint, threshold);
				}
			} else {
				if (currentDatapoint > threshold) {
					System.out.println("Alert:\n Output:" + r.getMetrics() + " \n Timestamp: " + r.getTimestamp());
					calculateDeviation(currentDatapoint, threshold);
				}
			}
		}
	}

	private void calculateDeviation(double currentPoint, double threshold) {
		double absoluteDifference = Math.abs(currentPoint - threshold);
		double percentageDifference = (absoluteDifference / threshold) * 100;
		System.out.println("Percentage Deviation: " + percentageDifference + "%\n");
	}

}
