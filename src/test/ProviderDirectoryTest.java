package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import service.serviceOffered.serviceOffered.ServiceOffered;

import org.junit.Test;
import service.serviceOffered.providerDirectory.*;

public class ProviderDirectoryTest {
	ProviderDirectory tester = new ProviderDirectory();

	@Test
	public void serviceFoundGivenValidCode() {
		assertEquals("Chocolate Bath", tester.getServiceByCode("135790").getServiceName());
		assertEquals(500, tester.getServiceByCode("135790").getServiceFee(), 0);
	}

	@Test
	public void serviceFoundGivenInvalidCode() {
		assertEquals(null, tester.getServiceByCode("1357900").getServiceName());
		assertEquals(0, tester.getServiceByCode("1357900").getServiceFee(), 0);
	}

	@Test
	public void providerDirectoryReturned() {
		assertEquals("Chocolate Therapy", tester.getProviderDirectory().get(0).getServiceName());
		assertEquals("Chocolate Bath", tester.getProviderDirectory().get(1).getServiceName());
		assertEquals(700, tester.getProviderDirectory().get(0).getServiceFee(), 0);
		assertEquals(500, tester.getProviderDirectory().get(1).getServiceFee(), 0);
	}

}
