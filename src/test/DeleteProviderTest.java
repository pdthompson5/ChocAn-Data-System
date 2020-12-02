package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import systemUser.Provider;
//@author Hannah Perkins
public class DeleteProviderTest {

    int num;

	@Before
	public void setUp() throws Exception {
        Provider provider = new Provider();
        provider.setName("Chris");
	}

	@Test
	public void testSetNameWorks() {
		assertEqualse("Chris", provider.getProviderName());
	}
	
	public void testDeleteProvider() {
        num = provider.getProviderNumber();
        OperatorController.deleteProvider(num);
	}
	
	public void testProviderNoLongerInNetwork() {
        fail(num, provider.getMemberNumber());
	}

}
