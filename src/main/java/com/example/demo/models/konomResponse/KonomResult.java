package com.example.demo.models.konomResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KonomResult {

	@JsonProperty("Impressions Delivered (HB Rendered Ad)")
	double impressionsDelivered;
	@JsonProperty("Output")
	double output;
	@JsonProperty("Timestamp")
	String timestamp;

	public double getImpressionsDelivered() {
		return impressionsDelivered;
	}

	public double getOutput() {
		return output;
	}

	public String getTimestamp() {
		return timestamp;
	}

}
