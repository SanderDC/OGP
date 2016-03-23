package dynamicBinding;

public abstract class BinaryExpression extends OperatorExpression {
	
	protected BinaryExpression(Expression leftOperand, Expression rightOperand)
			throws IllegalArgumentException{
		if (! canHaveAsOperand(leftOperand) || ! canHaveAsOperand(rightOperand))
			throw new IllegalArgumentException();
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	public Expression getLeftOperand(){
		return this.leftOperand;
	}
	
	public Expression getRightOperand(){
		return this.rightOperand;
	}
	
	@Override
	public Expression getOperandAt(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index > 1)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			return this.getLeftOperand();
		else
			return this.getRightOperand();
	}
	
	@Override
	public int getNbOperands(){ //final zetten om aan te geven dat die niet meer veranderd moet.
		return 2;
	}
	
	private final Expression leftOperand;
	
	private final Expression rightOperand;
	
}
