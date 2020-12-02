package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import provider.ProviderController;
import systemUser.Member;
//@author Topher Fryzel
public class VerifyMemberStatusTest {

	private ProviderController providerController = new ProviderController();
	
	@Before
	public void setUp() throws Exception {
		//Member member = new Member();
		//member.setMemberNumber("100000023");
		//member.setMemberStatus(false);
		
		Member member2 = new Member();
		member2.setMemberNumber("100000059");
		member2.setMemberStatus(false);
	}

	@Test
	public void testVerifyMemberStatusWhenTrue() {
		
		boolean expected = true;
		boolean verify = providerController.verifyMemberStatus("100000001");
		
		assertEquals(expected, verify);
	}
	
	@Test
	public void testVerifyMemberStatusWhenFalse() {
		boolean expected = false;
		boolean verify = providerController.verifyMemberStatus("100000002");
		
		assertEquals(expected, verify);
	}
	
	@Test
	public void testVerifyMemberStatusWhenNew() {
		boolean expected = false;
		boolean verify = providerController.verifyMemberStatus("100000059");
		
		assertEquals(expected, verify);
	}

}
