package com.example.demo.datasourceQueryRequestPayload;

public class KonomPayload extends DatasourceQuerypayload {


	public KonomPayload(String tableName, String metricsName, long granularity) {
		super(tableName, metricsName, granularity);
	}

	@Override
	public String generatePayload() {

		getTimeFrame(granularity);
		
		 String requestBody = "{\r\n"
		 		+ "    \"namespace\": \""+tableName+"\",\r\n"
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
		 		+ "                    \"alias\": \""+metricsName+"\",\r\n"
		 		+ "                    \"outputName\": \""+metricsName+"\",\r\n"
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
		 		+ "    \"startTime\": \""+startTime+"\",\r\n"
		 		+ "    \"endTime\": \""+endTime+"\"\r\n"
		 		+ "}";
		
		System.out.println(requestBody);
		
		return requestBody;
	}

}

/*
  String requestBody = "{\r\n"
		 		+ "    \"namespace\": \""+tableName+"\",\r\n"
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
		 		+ "                    \"alias\": \""+metricsName+"\",\r\n"
		 		+ "                    \"outputName\": \""+metricsName+"\",\r\n"
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
		 		+ "    \"startTime\": \""+startTime+"\",\r\n"
		 		+ "    \"endTime\": \""+endTime+"\"\r\n"
		 		+ "}";
 * 
 * */
