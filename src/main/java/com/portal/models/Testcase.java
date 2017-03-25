package com.portal.models;

import java.io.Serializable;

public class Testcase implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;  
	private String name;
	private String scenario;
	private String steps;
	private String testdata;
	private String expectedresults;
	private String deviceid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public String getTestdata() {
		return testdata;
	}
	public void setTestdata(String testdata) {
		this.testdata = testdata;
	}
	public String getExpectedresults() {
		return expectedresults;
	}
	public void setExpectedresults(String expectedresults) {
		this.expectedresults = expectedresults;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
}
