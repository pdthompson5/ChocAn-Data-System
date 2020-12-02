package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import operator.OperatorController;
import systemUser.Provider;
import systemUser.ProviderList;

/**
 * @author Ben Peinhardt
 */
public class AddProviderTest {

	@Test
	public void createProvider() {

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
			}
		}

		assertTrue(foundVal);
	}

	

}
