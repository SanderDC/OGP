package dynamicBinding;

public class Addition extends BinaryExpression {

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
