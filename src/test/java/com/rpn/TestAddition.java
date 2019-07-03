package com.rpn;

import com.rpn.exception.RPNCalculatorException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import java.util.Stack;

@ActiveProfiles("test")

public class TestAddition {

    @Value("${add.num1}")
    private String num1;

    @Value("${add.num2}")
    private String num2;

    @Value("${add.operation}")
    private String operation;

    @Test
    public void testExample1() throws RPNCalculatorException{
        String input = "5 2";
        common(input, "[5, 2]");
    }

    @Test
    public void testAddition() throws RPNCalculatorException{
        String input = "5 4 +";
        commonOperation(input, "9.0");
    }

    @Test
    public void testSubtraction()throws RPNCalculatorException{
        String input = "5 2 -";
        commonOperation(input, "3.0");
    }

    @Test
    public void testdivision()throws RPNCalculatorException{
        String input = "7 12 2 /";
        commonOperation(input, "6.0");
    }

    void commonOperation(String input, String actual)throws RPNCalculatorException{
        CreateOperation co = new CreateOperation();
        System.out.println(input);
        Stack<String> tempStack = co.push(input);
        System.out.println("Stack " + tempStack);
        Assert.assertEquals(tempStack.pop(), actual);
    }

    void common(String input, String actual)throws RPNCalculatorException{
        CreateOperation co = new CreateOperation();
        System.out.println(input);
        Stack<String> tempStack = co.push(input);
        System.out.println("Stack " + tempStack);
        Assert.assertEquals(tempStack.toString(), actual);
    }
}
