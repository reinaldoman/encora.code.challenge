/**
 * 
 */

package com.encora.balance.checker;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 */
public class CheckBalancedParenthesis {

	private static final Logger logger = LogManager.getLogger(CheckBalancedParenthesis.class);
	
	public static void main(String[] args) {

		List<String> expressions = Arrays.asList("()", "(()", "({})", "({)}", ")(", "[{[]}()]", "{}()");

		for (String expression : expressions) {
			String result = null;
			try {
				result = ParenthesisBalanceChecker.isBalanced(expression) ? "bien balanceado" : "mal balanceado";
			} catch (Exception e) {
				logger.log(Level.ERROR, "Unexpected expression ");
			}
			logger.log(Level.INFO, expression + ": " + result);
		}
	}

}
