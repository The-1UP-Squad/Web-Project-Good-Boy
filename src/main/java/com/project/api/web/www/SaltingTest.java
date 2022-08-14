package com.project.api.web.www;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SaltingTest {

	@Test
	void testDoingTheSalt() {
		String saltingtest = Salting.doingTheSalt("chris123");
		String returnsalt = Salting.doingTheSalt(theSalting.getPassWord);
		
		assertEquals(returnsalt, "inxoy789");
	}
}
