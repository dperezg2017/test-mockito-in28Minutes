package com.example.lab01;

import static org.junit.Assert.*;

import org.junit.*;

import com.in28Minutes.junit.helper.StringHelper;

public class StringHelperTest {
	
	static StringHelper helper;
	
	@BeforeClass
	public static void before() {
		helper = new StringHelper();
	}
	
	
	@Test
	public void testTruncateAInFirst2Positions_Ainfirst2Positions() {
		//AACD => CD   ACD => CD   CDEF=>CDEF  CDAA=CDAA
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD")); 
	}
	
	@Test
	public void testTruncateAInFirst2Positions2_AinFirstPosition() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	//ABCD => false , ABAB => true,  AB => true , A => false 
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegative() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositivo() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

}
