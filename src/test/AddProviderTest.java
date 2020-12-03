package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import jdk.jfr.Timestamp;
import operator.OperatorController;
import systemUser.Provider;
import systemUser.ProviderList;

/**
 * @author Ben Peinhardt
 */
public class AddProviderTest {

	private String testProviderNumber;

	@Test
	public void createProviderSuccess() {

		// Simulate creating the provider the way that the interface does
		OperatorController testOperatorController = new OperatorController();
		testOperatorController.addNewProvider("providerName", "providerStreetAddress", "providerCity", "providerState", "providerZip");

		// Get the provider
		ProviderList testProviderList = new ProviderList();
		ArrayList<Provider> providers = testProviderList.getProviderList();
		boolean foundVal = false;
		for (int i = 0; i < providers.size(); i++) {
			if (providers.get(i).getName().equals("providerName")) {
				foundVal = true;

				// Store provider number for other tests and teardown
				this.testProviderNumber = providers.get(i).getProviderNumber();
			}
		}

		testOperatorController.deleteProvider(this.testProviderNumber);
		assertTrue(foundVal);
	}

	@Test
	public void deleteProviderSuccess() {
		OperatorController testOperatorController = new OperatorController();
		testOperatorController.addNewProvider("providerName", "providerStreetAddress", "providerCity", "providerState", "providerZip");

		ProviderList testProviderList = new ProviderList();
		ArrayList<Provider> providers = testProviderList.getProviderList();
		boolean foundVal = false;
		for (int i = 0; i < providers.size(); i++) {
			if (providers.get(i).getName().equals("providerName")) {
				foundVal = true;

				// Store provider number for other tests and teardown
				this.testProviderNumber = providers.get(i).getProviderNumber();
			}
		}

		try {
			assertTrue(testOperatorController.verifyProviderExists(this.testProviderNumber));
			testOperatorController.deleteProvider(this.testProviderNumber);
			assertFalse(testOperatorController.verifyProviderExists(this.testProviderNumber));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void updateProviderShouldFail_ProviderDoesntExist() {
	
		try {
			OperatorController testOperatorController = new OperatorController();
			testOperatorController.deleteProvider(this.testProviderNumber);
			testOperatorController.updateProvider(this.testProviderNumber,"providerName", "providerStreetAddress", "providerCity", "providerState", "providerZip");
			String providerName = testOperatorController.getProvider(this.testProviderNumber).getName();
			System.out.println(providerName);
			System.out.println(providerName.charAt(0));
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}
