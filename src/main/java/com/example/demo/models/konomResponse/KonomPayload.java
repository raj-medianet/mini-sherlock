package com.example.demo.models.konomResponse;

import org.springframework.stereotype.Component;

public class KonomPayload {

	private String startTime, endTime, granularity, alias, outputName;

	public KonomPayload(String startTime, String endTime, String granularity, String alias, String outputName) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.granularity = granularity;
		this.alias = alias;
		this.outputName = outputName;
	}

	public String getRequestBody() {
        String requestBody = "{\r\n"
        		+ "    \"namespace\": \"Header Bidder\",\r\n"
        		+ "    \"dimensionObjectList\": [],\r\n"
        		+ "    \"metrics\": [],\r\n"
        		+ "    \"orderingMetric\": \"Metric1\",\r\n"
        		+ "    \"filters\": [],\r\n"
        		+ "    \"granularity\": "+granularity+",\r\n"
        		+ "    \"configId\": 7339,\r\n"
        		+ "    \"jobIdentifier\": \"-b\",\r\n"
        		+ "    \"customMeasures\": [\r\n"
        		+ "        {\r\n"
        		+ "            \"outputName\": \"Output\",\r\n"
        		+ "            \"customMeasureMetrics\": [\r\n"
        		+ "                {\r\n"
        		+ "                    \"alias\": \""+alias+"\",\r\n"
        		+ "                    \"outputName\": \""+outputName+"\",\r\n"
        		+ "                    \"filterIdList\": [\r\n"
        		+ "                        \"2\"\r\n"
        		+ "                    ]\r\n"
        		+ "                }\r\n"
        		+ "            ],\r\n"
        		+ "            \"formula\": \"${Impressions Delivered (HB Rendered Ad)} * 0.5\"\r\n"
        		+ "        }\r\n"
        		+ "    ],\r\n"
        		+ "    \"partialFilters\": {\r\n"
        		+ "        \"1\": [],\r\n"
        		+ "        \"2\": []\r\n"
        		+ "    },\r\n"
        		+ "    \"startTime\":\""+startTime+"\",\r\n"
        		+ "    \"endTime\":\""+endTime+"\"\r\n"
        		+ "}";
		return requestBody;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getGranularity() {
		return granularity;
	}

	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getOutputName() {
		return outputName;
	}

	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}

}
