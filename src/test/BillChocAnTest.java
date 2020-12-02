package test;
/**
 * @author Philip Thompson
 * Class Under Test: Provider Interface
 * Functionality under test: BillChocAn 
 */
import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


import provider.ProviderInterface;
import service.serviceProvidedPackage.serviceProvidedList.*;
import service.serviceProvidedPackage.serviceProvided.*;
public class BillChocAnTest {
	
	

	//Executes BillChocAn with: CMD input:100000007 2 100000008 11-26-2020 234567 Yes Was a great service 4
	@Test
	public void testSuccess() {
		ProviderInterface providerInterface = new ProviderInterface();
		ServiceProvidedList serviceProvidedList = new ServiceProvidedList();
		ServiceProvided service = serviceProvidedList.getServiceByMember("100000008").get(0);
		
		if(!service.getMemberNumber().equals("100000008")) {
			fail();
		}
		if(!service.getDate().equals("11-26-2020")) {
			fail();
		}
		if(!service.getServiceCode().equals("234567")) {
			fail();
		}
		if(!service.getComments().equals("Was a great service")) {
			fail();
		}
	}
	
	//executes BillChocAn with: CMD input:100000007 2 100000006 4
	//tests for suspended member
	@Test 
	public void testFail1() {
		ProviderInterface providerInterface = new ProviderInterface();
		ServiceProvidedList serviceProvidedList = new ServiceProvidedList();
		ArrayList<ServiceProvided> serviceList = serviceProvidedList.getServiceByMember("100000006");
		
		assertTrue(serviceList.size() == 0);
	}
	
	//executes BillChocAn with: CMD input:100000007 2 100000089 4
	//tests for invalid member number 
	@Test
	public void testFail2(){
		ProviderInterface providerInterface = new ProviderInterface();
		ServiceProvidedList serviceProvidedList = new ServiceProvidedList();
		ArrayList<ServiceProvided> serviceList = serviceProvidedList.getServiceByMember("100000089 ");
		
		assertTrue(serviceList.size() == 0);
		
	}
	
	
	
	
	
	

}
