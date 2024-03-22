package com.encora.balance.checker;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParenthesisBalanceCheckerTest {

	@Test
    public void testBalancedExpression() throws Exception {
        assertTrue(ParenthesisBalanceChecker.isBalanced("()"));
		assertTrue(ParenthesisBalanceChecker.isBalanced("({})"));
		assertTrue(ParenthesisBalanceChecker.isBalanced("[{[]}()]"));
	    assertTrue(ParenthesisBalanceChecker.isBalanced("{}()"));
	    assertTrue(ParenthesisBalanceChecker.isBalanced("((a+b)*(c-d))"));
	    assertFalse(ParenthesisBalanceChecker.isBalanced(")(a+b)*(c-d)("));
		
    }
    
    @Test
    public void testUnbalancedExpression() throws Exception {
        assertFalse(ParenthesisBalanceChecker.isBalanced("(()"));
		assertFalse(ParenthesisBalanceChecker.isBalanced("({)}"));
	    assertFalse(ParenthesisBalanceChecker.isBalanced(")("));
	    assertFalse(ParenthesisBalanceChecker.isBalanced("{[}]"));
    }
    
    @Test
    public void testEmpty() throws Exception {
        assertTrue(ParenthesisBalanceChecker.isBalanced(""));
    }
}
