package com.chocan.report;

import com.chocan.report.eft.EftData;

import com.chocan.report.member.MemberReportController;
import com.chocan.report.provider.ProviderReportController;
import com.chocan.report.summary.SummaryReportController;

import com.chocan.service.provided.ServiceProvidedController;

public class ReportController {
	public String produceEFTData();
	{
		return ;
	}
	public String produceMemberReport(String memberNumber){
		for(int i = 0; i< serviceProvidedList.length; ++i) {
			if(memberNumber.equals(serviceProvidedList[i].member.memberNumber)) {
				
			}
		}
	}
	public String produceProviderReport(String providerNumber) {
		
		for(int i = 0; i< serviceProvidedList.length; ++i) {
			if(providerNumber.equals(serviceProvidedList[i].provider.providerNumber)) {
				
			}
		}
	}
	public String produceSummaryReport(){
		
	}
	public String[] produceAllMemberReports() {
		String allMemberReports[];
		for(int i = 0; i< /* number of members**/; ++i) {
			//allMemberReports[i] = produceMemberReport(serviceProvidedList[]);
		}
	}
	public String[] produceAllProviderReports() {
		String allProviderReports[];
		for(int i = 0; i< /* number of providers**/; ++i) {
			//allProviderReports[i] = produceProviderReport(serviceProvidedList[]);
		}
	}
}
