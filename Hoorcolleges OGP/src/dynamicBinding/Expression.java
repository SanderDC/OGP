package dynamicBinding;

/**
 * A class of expressions involving integer numbers.
 * @author Sander Declercq
 *
 */
public abstract class Expression {
	
	public abstract long getValue();
	
	public abstract String toPostfix();
	
	public boolean hasAsSubExpression(Expression expression){
		return this == expression;
	};//hier al return this == expression schrijven, moet niet meer in Number
	
}
