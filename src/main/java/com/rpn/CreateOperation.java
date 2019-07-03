package com.rpn;

import com.rpn.exception.RPNCalculatorException;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Logic handling for all Arithmetic Operations:
 *  + - / * sqrt
 *
 * @author Shruti Sinha Mahapatra
 * 
 */
public class CreateOperation implements Operations{
	private Stack<String> tempStack;

	public CreateOperation() {
		tempStack = new Stack<>();
	}

	DecimalFormat df = new DecimalFormat("#.##########");

	public Stack<String> push(String input) throws RPNCalculatorException
	{
		String str = input;
		String[] splited = str.split("\\s+");
		for(String temp : splited) {

			if("undo".equalsIgnoreCase(temp))
				undoInStack();

			else if ("clear".equalsIgnoreCase(temp))
					clearStack();

			else if(Pattern.matches("[[\\+][\\/][\\*][\\-]]", temp)) {

				if(tempStack.size() < 2) {
					System.out.println("Operator " + temp + " (position) " +(tempStack.size()+1) +
							" : insufficient parameters (there has to be minimum 2 elements in stack)");
					throw new RPNCalculatorException("insufficient parameters");
				}

				Double num2 = new Double(tempStack.pop());
				Double num1 = new Double(tempStack.pop());

				switch (temp){
					case "+":
						addTopTwo(num1, num2);
						break;
					case "-":
						subtractTopTwo(num1, num2);
						break;
					case "*":
						multiplyTopTwo(num1, num2);
						break;
					case "/":
						divideTopTwo(num1, num2);
						break;
				}
			}
			else if("sqrt".equalsIgnoreCase(temp)) {

				if(tempStack.size() < 1) {
					System.out.println("Operator " + temp + " (position) " +(tempStack.size()+1) +
							" : insufficient parameters (there has to be minimum 1 elements in stack)");
				}
				sqrtElement();
			}
			else if(Pattern.matches("[\\d]*", temp) && !temp.trim().equals(""))
				tempStack.push(temp);

			else if("exit".equalsIgnoreCase(temp) || "quit".equalsIgnoreCase(temp))
				tempStack.push(temp);

			else
				System.out.println("--- Invalid entry ---");
		}
		return tempStack;
	}

	public void subtractTopTwo(Double num1, Double num2){
		tempStack.push((num1-num2) + "");
	}

	public void addTopTwo(Double num1, Double num2){
		tempStack.push((num1+num2)+"");
	}

	public void multiplyTopTwo(Double num1, Double num2){
		tempStack.push((num1*num2)+"");
	}

	public void divideTopTwo(Double num1, Double num2){
		// tempStack.push(num1.divide(num2).setScale(15, RoundingMode.FLOOR) + "");
		Double temp = new Double(df.format(num1/num2));
		tempStack.push(temp + "");
	}

	public void sqrtElement(){
		Double num1 = new Double(tempStack.pop());
		num1 = new Double(df.format(Math.sqrt(num1)));

		if(num1.isNaN())
			num1 = 1.0;

		tempStack.push(num1.toString());
	}

	public void undoInStack(){
		if(tempStack.size()>0)
			tempStack.pop();
		else
			System.out.println("Stack is empty");
	}

	public void clearStack(){
		if(tempStack.size()>0)
			tempStack.clear();
		else
			System.out.println("Stack is empty");
	}
}
