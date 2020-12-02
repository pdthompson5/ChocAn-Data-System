package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import provider.ProviderController;
import systemUser.Member;

public class VerifyMemberStatusTest {

	private ProviderController providerController = new ProviderController();
	
	@Before
	public void setUp() throws Exception {
		Member member = new Member();
		member.setMemberNumber("100000001");
		member.setMemberStatus(false);
	}

	@Test
	public void testVerifyMemberStatus() {
		
		boolean expected = false;
		boolean verify = providerController.verifyMemberExists("100000001");
		
		assertEquals(expected, verify);
	}
	

}
