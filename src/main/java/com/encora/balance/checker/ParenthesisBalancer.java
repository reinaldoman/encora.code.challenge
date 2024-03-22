package com.encora.balance.checker;

import java.util.Arrays;
import java.util.List;

public class ParenthesisBalancer {
    
	
    public static boolean isBalaced(String expresion) {
    	//Initialize three counters for each of the parenthesis types
        int parenthesisCounter = 0;
        int squareBracketsCounter = 0;
        int bracesCounter = 0;
        
        /**
         * Determine parenthesis type and if an opening parenthesis then increase the count of opened parenthesis for the corresponding type.
         * If a closing parenthesis then decrease the correct counter
         */
        for (char caracter : expresion.toCharArray()) {
            if (caracter == '(') {
                parenthesisCounter++;
            } else if (caracter == ')') {
                parenthesisCounter--;
            } else if (caracter == '[') {
                squareBracketsCounter++;
            } else if (caracter == ']') {
                squareBracketsCounter--;
            } else if (caracter == '{') {
                bracesCounter++;
            } else if (caracter == '}') {
                bracesCounter--;
            }
            
            //If one of the counters is lower than zero it means and opening parenthesis is missing
            if (parenthesisCounter < 0 || squareBracketsCounter < 0 || bracesCounter < 0) {
                return false;
            }
        }
        
        //If all of the counters are zero at the end it means the expression is balanced.
        return parenthesisCounter == 0 && squareBracketsCounter == 0 && bracesCounter == 0;
    }
    
    public static void main(String[] args) {
    	
    	List<String> expressions = Arrays.asList("()", "(()", "({})", "({)}", ")(:", "[{[]}()]", "{}()");
        
        for (String expresion : expressions) {
            System.out.println(expresion + ": " + (isBalaced(expresion) ? "bien balanceado" : "mal balanceado"));
        }
    }
}