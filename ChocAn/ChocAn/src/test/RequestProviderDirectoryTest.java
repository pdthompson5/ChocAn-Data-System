package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import service.serviceOffered.providerDirectory.ProviderDirectory;
import service.serviceOffered.serviceOffered.ServiceOffered;
import systemUser.Provider;

//@author
public class RequestProviderDirectoryTest {

	private ProviderDirectory providerDirectory = new ProviderDirectory();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRequestProviderDirectory() {
		ServiceOffered service = new ServiceOffered();
		service.setServiceCode("123456");
		service.setServiceFee(100);
		service.setServiceName("Chocowow");
		
		ServiceOffered service2 = new ServiceOffered();
		service2.setServiceCode("654321");
		service2.setServiceFee(450);
		service2.setServiceName("Chocomania");
		
		ArrayList<ServiceOffered> myProviderDirectory = new ArrayList<ServiceOffered>();
		myProviderDirectory = providerDirectory.getProviderDirectory();
		
		System.out.print("Service Code should be 123456: ");
		System.out.println(myProviderDirectory.get(0).getServiceCode());
		
		System.out.print("Service Code should be 654321: ");
		System.out.println(myProviderDirectory.get(1).getServiceCode());		
		
	}

}
