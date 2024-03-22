package com.encora.balance.checker;

import java.util.Arrays;
import java.util.List;

public class ParenthesisBalancer {
    
	
    public static boolean isBalaced(String expresion) {
    	//Initialize three counters for each of the parenthesis types
        int contadorParentesis = 0;
        int contadorCorchetes = 0;
        int contadorLlaves = 0;
        
        /**
         * Determine parenthesis type and if an opening parenthesis then increase the count of opened parenthesis for the corresponding type.
         * If a closing parenthesis then decrease the correct counter
         */
        for (char caracter : expresion.toCharArray()) {
            if (caracter == '(') {
                contadorParentesis++;
            } else if (caracter == ')') {
                contadorParentesis--;
            } else if (caracter == '[') {
                contadorCorchetes++;
            } else if (caracter == ']') {
                contadorCorchetes--;
            } else if (caracter == '{') {
                contadorLlaves++;
            } else if (caracter == '}') {
                contadorLlaves--;
            }
            
            //If one of the counters is lower than zero it means and opening parenthesis is missing
            if (contadorParentesis < 0 || contadorCorchetes < 0 || contadorLlaves < 0) {
                return false;
            }
        }
        
        //If all of the counters are zero at the end it means the expression is balanced.
        return contadorParentesis == 0 && contadorCorchetes == 0 && contadorLlaves == 0;
    }
    
    public static void main(String[] args) {
    	
    	List<String> expressions = Arrays.asList("()", "(()", "({})", "({)}", ")(:", "[{[]}()]", "{}()");
        
        for (String expresion : expressions) {
            System.out.println(expresion + ": " + (isBalaced(expresion) ? "bien balanceado" : "mal balanceado"));
        }
    }
}