package com.chocan.report.eft;

import com.chocan.service.provided.ServiceProvided;

//import com.chocan.report; don't think this is necessary?

//set up file containing provider name, provider number, amount to be transferred

public class EftData {
	private ServiceProvided servicesForWeek[]; 
	private String EFTData;
	
	public String produceEFTData(ServiceProvided servicesForWeek[]) {
		
		//what should this do?
		for(int i = 0; i<servicesForWeek.length; ++i) { //this should find the length of the array?
			EFTData += servicesForWeek[i];
		}
		
		return EFTData;
	}
	private void writeProviderName() {
		//write provider name to the file
	}
	private void writeProviderNumber(){
		//write provider number to the file
	}
	private void writeFeeToBeTransferred() {
		//write amount to be transferred
	}
}
