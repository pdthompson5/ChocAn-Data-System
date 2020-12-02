package test;
/**
 * @author Philip Thompson
 * Class Under Test: Provider Interface
 * Functionality under test: BillChocAn 
 */
import static org.junit.Assert.*;

import java.io.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


import provider.ProviderInterface;
import service.serviceProvidedPackage.serviceProvidedList.*;
import service.serviceProvidedPackage.serviceProvided.*;
public class BillChocAnTest {
	ProviderInterface providerInterface;
	InputStream sysInBackup;
	ByteArrayInputStream in;
	

	@Before
	public void setUp() throws Exception {
		sysInBackup = System.in;
		in = new ByteArrayInputStream("100000007".getBytes());
		System.setIn(in);
		providerInterface = new ProviderInterface();
		in.readAllBytes();
		 // backup System.in to restore it later
		//input provider number
		
		
	}

	@Test
	public void test() {
		providerInterface.billChocAn("100000008");
		
		//input date
		in = new ByteArrayInputStream("11-26-2020".getBytes());
		System.setIn(in);
		in.readAllBytes();
		
		//input service code 
		in = new ByteArrayInputStream("100000".getBytes());
		in.readAllBytes();
		
		//input comments
		in = new ByteArrayInputStream("Was a great service".getBytes());
		in.readAllBytes();
		
		ServiceProvidedList serviceProvidedList = new ServiceProvidedList(0);
		ServiceProvided service = serviceProvidedList.getServiceByMember("100000008").get(0);
		
		if(service.getMemberNumber().equals("100000008")) {
			fail();
		}
		if(service.getDate().equals("11-26-2020")) {
			fail();
		}
		if(service.getServiceCode().equals("100000")) {
			fail();
		}
		if(service.getComments().equals("Was a great service")) {
			fail();
		}
	}
	
	@Test
	public void test2() {
		
	}
	
	
	@Test
	public void test3(){
		
	}
	
	@After
	public void tearDown() {
		System.setIn(sysInBackup);
	}
	
	
	

}
