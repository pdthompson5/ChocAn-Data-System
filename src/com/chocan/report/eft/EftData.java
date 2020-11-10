package com.chocan.report.eft;

//import com.chocan.report; don't think this is necessary?
import com.chocan.service.provided.ServiceProvided;

//set up file containing provider name, provider number, amount to be transferred

public class EftData {
	private ServiceProvided[] servicesForWeek; 
	private String EFTData;
	
	public String produceEFTData(ServiceProvided[] serviceProvidedList) {
		
		//what should this class do?
//		for(int i = 0; i<serviceProvidedList.length; ++i) { //this should find the length of the array?
//			System.out.print(serviceProvidedList[i]
//			System.out.print(" ")
//		}
		
		return ;
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
