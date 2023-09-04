package com.example.demo.models.konomResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public class KonomResponse {
	ArrayList<KonomResult> konomResult = new ArrayList<KonomResult>();
	private String error = null;
	private boolean isValid;
	private String errorMap = null;
	private double threshold;
	DataValidInfo dataValidInfo;
	private String validationLink;

	// Getter Methods

	public List<KonomResult> getResult() {
		return konomResult;
	}

	public String getError() {
		return error;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public String getErrorMap() {
		return errorMap;
	}

	public double getThreshold() {
		return threshold;
	}

	public DataValidInfo getDataValidInfo() {
		return dataValidInfo;
	}

	public String getValidationLink() {
		return validationLink;
	}

}
