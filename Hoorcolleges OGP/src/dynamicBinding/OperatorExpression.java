package dynamicBinding;

public abstract class OperatorExpression extends Expression {

	public abstract Expression getOperandAt(int index) throws IndexOutOfBoundsException;
	
	public abstract int getNbOperands();
	
	public boolean canHaveAsOperand(Expression expression){
		if (expression == null)
			return false;
		return ! expression.hasAsSubExpression(this);
	}
	
	@Override
	public boolean hasAsSubExpression(Expression expression){
		if (this == expression)
			return true;
		for (int i = 0; i < getNbOperands(); i++){
			if (getOperandAt(i).hasAsSubExpression(expression))
				return true;
		}
		return false;
	}
	
//	private final List<Expression> operands = new ArrayList<>();
//	Keuze voor representatie op lagere niveaus maken ==> getter wordt abstract
	
}
