package dynamicBinding;

public class Number extends Expression {
	
	public Number(long value){
		this.value = value;
	}
	
	@Override
	public long getValue() {
		return this.value;
	}

	@Override
	public String toPostfix() {
		return Long.toString(this.getValue());
	}
	
	@Override
	public String toString(){
		return "Number with value: " + this.getValue();
	}
	
	@Override
	public boolean equals(Object object){
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		return this.getValue() == ((Number) object).getValue();
	}
	
	@Override
	public int hashCode(){
		return (int) this.getValue();
	}
	
//	@Override
//	public boolean hasAsSubExpression(Expression expression){
//		return this == expression;
//	}
	
	private final long value;
}
