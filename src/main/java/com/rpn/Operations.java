package com.rpn;

/**
 * The Interface to allow access to the available CreateOperation.
 *
 * @author Shruti Sinha Mahapatra
 *
 */

public interface Operations {

	void subtractTopTwo(Double num1, Double num2);

	void addTopTwo(Double num1, Double num2);

	void multiplyTopTwo(Double num1, Double num2);

	void divideTopTwo(Double num1, Double num2);

	void undoInStack();

	void clearStack();

	void sqrtElement();
}