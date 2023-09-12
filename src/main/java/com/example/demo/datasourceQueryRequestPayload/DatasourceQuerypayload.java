package com.example.demo.datasourceQueryRequestPayload;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DatasourceQuerypayload {

	protected String tableName, metricsName, customMeasureOutputName, startTime, endTime;
	long granularity;

	public DatasourceQuerypayload(String tableName, String metricsName, long granularity) {
		this.tableName = tableName;
		this.metricsName = metricsName;
		this.granularity = granularity;
		this.customMeasureOutputName = "Output";
	}

	public abstract String generatePayload();

	void getTimeFrame(long granularityInMins) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long granularity = granularityInMins*60000;

		Date currentTime = new Date();
		Date roughStartDate = new Date(currentTime.getTime() - granularity);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(roughStartDate.getTime());
		int min = calendar.get(Calendar.MINUTE);

		if (min <= 59 && min >= 45)
			min = 45;
		else if (min <= 44 && min >= 30)
			min = 30;
		else if (min <= 29 && min >= 15)
			min = 15;
		else
			min = 0;

		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);

		startTime = simpleDateFormat.format(calendar.getTime());
		
		endTime = simpleDateFormat.format(calendar.getTimeInMillis()+granularity);

	}

	// hardcoded timeframe
//	void getTimeFrame(long granularity) {
//		startTime = "2023-08-28 06:00:00";
//		endTime = "2023-08-28 06:30:00";
//	}

	public String getCustomMeasureOutputName() {
		return customMeasureOutputName;
	}

	public String getMetricsName() {
		return metricsName;
	}

	public long getGranularity() {
		return granularity;
	}

}
