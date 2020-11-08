package com.chocan.service.offered;

import java.math.BigDecimal; 

public class ServiceOffered {
	private String serviceName;
	private String serviceCode;
	private BigDecimal serviceFee;
	
	public ServiceOffered(String serviceName, String serviceCode, BigDecimal serviceFee) {
		this.serviceName = serviceName;
		this.serviceCode = serviceCode;
		this.serviceFee = serviceFee;
	}

	// Getters
	public String getServiceName() {
		return serviceName;
	}
	
	public String getServiceCode() {
		return serviceCode;
	}

	public BigDecimal getServiceFee() {
		return serviceFee;
	}
	
	// Setters	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}
}
