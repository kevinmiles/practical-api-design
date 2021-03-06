/*
 * Factory.java
 *
 * Created on July 12, 2006, 2:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.netbeans.apifest.boolcircuit;

/**
 *
 */
public class Factory {
    
    /** Creates a new instance of Factory */
    private Factory() {
    }
    
    /**
     * @deprecated use for constants only.. use VariableInput instead..
     */
    public static Input createSimpleBooleanInput(boolean value) {
        return new BooleanInput(value);
    }
    
    public static VariableInput createVariableInput() {
        return new VariableInput();
    }
    /**
     * @throws IllegalArgument if the boolean operation was already used as input for another operation..
     * @deprecated
     */
    public static Input createOperationBasedBooleanInput(Operation op) throws IllegalArgumentException {
        assert op != null;
        if (op.isUsed()) {
            throw new IllegalArgumentException("Cannot use a single operation repeatedly.");
        }
        op.markOperationAsUsed();
        return new OperationInput(op);
    }
    
    /**
     * WTF, just make another reasonable sounding factory method now that we have reals..
     */
    
    public static Input createOperationBasedInput(Operation op) throws IllegalArgumentException {
        return createOperationBasedBooleanInput(op);
    }
    
    public static Operation createAndOperation(Input one, Input two) {
        assert one != null;
        assert two != null;
        return new AndOperation(one, two);
    }
    
    public static Operation createOrOperation(Input one, Input two) {
        assert one != null;
        assert two != null;
        return new OrOperation(one, two);
    }
    
    public static Operation createNotOperation(Input one) {
        assert one != null;
        return new NotOperation(one);
    }
    
    
}
