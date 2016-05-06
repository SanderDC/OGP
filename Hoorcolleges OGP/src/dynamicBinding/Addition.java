package dynamicBinding;

public class Addition extends BinaryExpression {

	public Addition(Expression leftOperand, Expression rightOperand) throws IllegalArgumentException {
		super(leftOperand, rightOperand);
	}

	@Override
	public long getValue() {
		return this.getLeftOperand().getValue() + this.getRightOperand().getValue();
	}

	@Override
	public String toPostfix() {
		return this.getLeftOperand().toPostfix() + " " + 
				this.getRightOperand().toPostfix() + " +";
	}

}
