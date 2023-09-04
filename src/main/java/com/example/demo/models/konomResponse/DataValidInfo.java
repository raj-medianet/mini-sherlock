package com.example.demo.models.konomResponse;

public class DataValidInfo {
	private float realtimeLagThresholdMins;
	private float batchDelayThresholdMins;
	private boolean isHigherRetention;
	private float maxCountMismatchPercentage;
	private float maxTotalMissingRowsPercentage;
	private float numIntervalsNotIngested;
	private float realtimeLagMins;
	private float countMismatchThresholdPercentage;

	// Getter Methods

	public float getRealtimeLagThresholdMins() {
		return realtimeLagThresholdMins;
	}

	public float getBatchDelayThresholdMins() {
		return batchDelayThresholdMins;
	}

	public boolean getIsHigherRetention() {
		return isHigherRetention;
	}

	public float getMaxCountMismatchPercentage() {
		return maxCountMismatchPercentage;
	}

	public float getMaxTotalMissingRowsPercentage() {
		return maxTotalMissingRowsPercentage;
	}

	public float getNumIntervalsNotIngested() {
		return numIntervalsNotIngested;
	}

	public float getRealtimeLagMins() {
		return realtimeLagMins;
	}

	public float getCountMismatchThresholdPercentage() {
		return countMismatchThresholdPercentage;
	}

}