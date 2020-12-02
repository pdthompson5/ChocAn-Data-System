package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import systemUser.Provider;

public class AddProviderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddProviderForNameLength() {
		Provider provider = new Provider();
		provider.setName("CowCowCowPigPigSheepJavaCodeWowowwowowowowowoow");
	}
	
	public void testAddProviderForStateLength() {
		Provider provider = new Provider();
		provider.setState("Illinoise");
	}
	
	public void testAddProviderForAddressLength() {
		Provider provider = new Provider();
		provider.setStreetAddress("12344510459 Mulberry Lane Apt 2095 Building 9");
	}

}
