package dynamicBinding.expressions;

import dynamicBinding.expressions.exceptions.*;

/**
 * A class of binary expressions, representing the subtraction of the
 * operand at the right-hand side from the operand at the left-hand
 * side.
 */

public class Subtraction extends BinaryExpression {

	/**
	 * Initialize this new subtraction with given operands.
	 *
	 * @param  left
	 *		   The left operand for this new subtraction.
	 * @param  right
	 *		   The right operand for this new subtraction.
	 * @effect This new subtraction is initialized as a binary expression
	 *         with the given operands.
	 *       | super(left,right)
	 */
	public Subtraction(Expression left, Expression right)
			throws IllegalOperandException {
		super(left, right);
	}

	/**
	 * Return the value of this subtraction.
	 *
	 * @return The difference between the value of the left operand
	 *		   and the right operand of this subtraction.
	 *       | result ==
	 *       |   getLeftOperand().getValue() - 
	 *       |   getRightOperand().getValue()
	 */
	@Override
	public long getValue() {
		return getLeftOperand().getValue() - getRightOperand().getValue();
	}

	/**
	 * Return the symbol representing the operator of this subtraction.
	 * 
	 * @return The string "-"
	 *       | result.equals("-")
	 */
	@Override
	public String getOperatorSymbol() {
		return "-";
	}

}