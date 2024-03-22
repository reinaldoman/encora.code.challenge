/**
 * @author reinaldo
 */

package com.encora.balance.checker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

/**
 * 
 */
public class ParenthesisBalanceChecker {

	
	private static final Map<Character, Character> PARENTHESIS_MAP = new HashMap<>();
	
	private ParenthesisBalanceChecker() {
		
	}
    
    static {
    	//TODO: Populate this map from some configuration to allow more types of parenthesis to be added or removed
        PARENTHESIS_MAP.put('(', ')');
        PARENTHESIS_MAP.put('{', '}');
        PARENTHESIS_MAP.put('[', ']');
    }
	
    
    /**
     * Iterate over the incoming expression to determine if it contains opening or closing parenthesis. 
     * If it's an opening parenthesis, add it to the stack to mark the last opening parenthesis found. 
     * If it's a closing parenthesis, search for the corresponding opening pair and compare them to determine if they are different, 
     * in which case the expression is not balanced correctly.
     */
    public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
        
        for (char character : expression.toCharArray()) {
        	if (PARENTHESIS_MAP.containsKey(character)) {//Opening character
            	stack.push(character);
            } else if (PARENTHESIS_MAP.containsValue(character)) { //closing parenthesis...
                
            	if (stack.isEmpty()) {
                    return false;
                }
                
                char lastOpenedParenthesis = stack.pop();
                Optional<Character> openingPair = PARENTHESIS_MAP.entrySet().stream()
                															.filter(entry -> character == entry.getValue())
															                .map(Map.Entry::getKey)
															                .findFirst();
                if(!openingPair.isPresent())
                	return false;
                if (lastOpenedParenthesis != openingPair.get()) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
	}

}
