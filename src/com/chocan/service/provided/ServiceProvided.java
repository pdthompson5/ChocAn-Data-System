package com.chocan.service.provided;

// Imports for references to other classes
import com.chocan.service.offered.ServiceOffered;
import com.chocan.user.member.Member;
import com.chocan.user.provider.Provider;

public class ServiceProvided {
	private String serviceProvidedID;
	private String timeProvided;
	private String serviceDate;
	private Provider provider;
	private Member member;
	private ServiceOffered service;
	private String comments;

	public ServiceProvided(String serviceProvidedID, String timeProvided, String serviceDate, Provider provider, Member member, ServiceOffered service, String comments) {
		this.setServiceProvidedID(serviceProvidedID);
		this.setTimeProvided(timeProvided);
		this.setServiceDate(serviceDate);
		this.setProvider(provider);
		this.setMember(member);
		this.setService(service);
		this.setComments(comments);
	}

	// Getters
	public String getServiceProvidedID() {
		return serviceProvidedID;
	}

	public String getTimeProvided() {
		return timeProvided;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public Provider getProvider() {
		return provider;
	}

	public Member getMember() {
		return member;
	}

	public ServiceOffered getService() {
		return service;
	}

	public String getComments() {
		return comments;
	}

	// Setters	
	public void setServiceProvidedID(String serviceProvidedID) {
		this.serviceProvidedID = serviceProvidedID;
	}

	public void setTimeProvided(String timeProvided) {
		this.timeProvided = timeProvided;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setService(ServiceOffered service) {
		this.service = service;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
