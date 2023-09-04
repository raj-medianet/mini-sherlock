package com.example.demo.monitorService;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.models.Datasource;
import com.example.demo.models.konomResponse.KonomPayload;
import com.example.demo.models.konomResponse.KonomResponse;
import com.example.demo.models.konomResponse.KonomResult;

@Service
public class MonitorKonom implements MonitorService<KonomResponse>{

	public KonomResponse monitorDatasource(Datasource datasource, String startTime, String endTime,
			String granularity) {

		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = datasource.getUrl();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("X-KONOM-GROUPS", "CM-DEV");
		headers.add("X-AUTH-TOKEN", "c69987ee-48e3-44ec-8ea1-778649fd3699");
		headers.add("X-KONOM-USER", "kunal.chau");

		KonomPayload konomPayload = new KonomPayload(startTime, endTime, granularity,
				"Impressions Delivered (HB Rendered Ad)", "Impressions Delivered (HB Rendered Ad)");
		String requestBody = konomPayload.getRequestBody();

		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
		KonomResponse response = null;
		try {
			response = restTemplate.postForObject(apiUrl, requestEntity, KonomResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(response!=null) {
			List<KonomResult> konomResults = response.getResult();
			double threshold = response.getThreshold();
			for (KonomResult r : konomResults) {
				if (r.getOutput() < threshold) {
					System.out.println("datapoint less than threshold " + r.getOutput() + " " + r.getTimestamp());
				}
			}
		}
		return response;
	}

}
