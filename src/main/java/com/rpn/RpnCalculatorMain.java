package com.rpn;

/**
 * The executable class for the RPN Calculator.
 * @author Shruti Sinha Mahapatra
 *
 */

import com.rpn.exception.RPNCalculatorException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.Stack;

@SpringBootApplication
public class RpnCalculatorMain {

	/**
	 * The main method to be executed in order to start the RPN Calculator.
	 * 
	 * @param args
	 */

	public static void main(String[] args) throws RPNCalculatorException {
		CreateOperation co = new CreateOperation();
		System.out.println("Enter Numbers to be added in stack and" +
				" operands(+ - * / sqrt undo clear exit quit ) :");

		while (true) {
			Scanner userInput = new Scanner(System.in);  // Create a Scanner object
			String input = userInput.nextLine();  // Read user input
			Stack<String> tempStack = co.push(input); // pushes all elements in stack
			System.out.println("Stack " + tempStack);
			if(tempStack.size()>0 && tempStack.lastElement().contains("exit"))
					break;
		}
	}
}
