import static org.junit.Assert.*;

import org.junit.Test;

import com.elena.accountbuilder.controllers.AccountBuilder;

public class TestAccountBuilder {

	
	
	@Test
	public void checkIfStringContainsWhiteSpace() {
		String name = "Elena Alexandra";
		boolean found = AccountBuilder.checkIfNameContainsWhiteSpace(name);
		assertTrue(found);
	}
	
	@Test
	public void checkIfStringContainsLineDelimiter() {
		String name = "Elena-Alexandra";
		boolean found = AccountBuilder.checkIfNameContainsLineDelimiter(name);
		assertTrue(found);
	}
	
	@Test
	public void testUsernameGeneration() {
		String firstName = "Elena-Alexandra";
		String lastName = "Dobrescu";
		AccountBuilder accbuilder = new AccountBuilder();
		String username = accbuilder.generateUserNameWithOneFirstname(firstName, lastName);
		System.out.println(username);
		assertEquals(username, "Elena_Dobrescu");
		
	}

}
