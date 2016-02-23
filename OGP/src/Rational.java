import be.kuleuven.cs.som.annotate.*;

/**
 * A class of rational numbers involving a numerator ('teller')
 * and a denominator ('noemer')
 * @invar	...
 * 			| this.getDenominator() != 0
 * @invar	...
 * 			| ExtMath.gcd(Math.abs(this.getNumerator), this.getDenominator()) == 1
 * 
 * @author 1e Bachelor Informatica
 */
public class Rational {
	
	/**
	 * 
	 * @param numerator
	 * @param denominator
	 * @post	...
	 * 			| new.getDenominator() == Math.abs(denominator)
	 * @post	...
	 * 			| if (denominator > 0)
	 * 			| then new.getNumerator() == numerator
	 * 			| else new.getNumerator() == -numerator
	 * @throws IllegalDenominatorException
	 * 			...
	 * 			| denominator == 0
	 * 			
	 */
	public Rational(long numerator, long denominator) throws IllegalDenominatorException{
		if (denominator == 0)
			throw new IllegalDenominatorException(denominator);
		this.denominator = Math.abs(denominator);
		this.numerator = ExtMath.sign(denominator)*numerator;
	}
	
	/**
	 * Return the numerator of this rational number.
	 */
	@Basic @Immutable
	public long getNumerator() {
		return this.numerator;
	}
	
	/**
	 * Variable registering the numerator of this rational number.
	 */
	private final long numerator;
	
	/**
	 * Return the denominator of this rational number.
	 */
	@Basic @Immutable
	public long getDenominator() {
		return this.denominator;
	}
	
	/**
	 * Variable registering the numerator of this rational number.
	 */
	private final long denominator;
	
	/**
	 * 
	 * @param other
	 * @return
	 * @throws NullPointerException
	 * 			| other == null
	 */
	public boolean isIdenticalTo(Rational other) throws NullPointerException{
		return (this.getNumerator() == other.getNumerator()) && (this.getDenominator() == other.getDenominator());
	}
	
	public boolean hasSameValueAs(Rational other) throws NullPointerException {
		return this.normalize().isIdenticalTo(other.normalize());
	}
	
	/**
	 * 
	 * @return
	 */
	public Rational normalize() {
		long gcd = ExtMath.gcd(this.getNumerator(), this.getDenominator());
		return new Rational(this.getNumerator()/gcd,this.getDenominator()/gcd);
	}
	
	public Rational multiply(long factor) throws TimesOverflowException{
		try {
			long newNumerator = ExtMath.times(this.getNumerator(), factor);
			return new Rational(newNumerator, this.getDenominator());
		} catch (TimesOverflowException exc) {
			Rational thisNormalized = this.normalize();
			if (thisNormalized.getNumerator() < this.getNumerator())
				return thisNormalized.multiply(factor);
			Rational other = new Rational(factor, this.getDenominator()).normalize();
			if (this.getDenominator() != other.getDenominator())
				return other.multiply(this.getNumerator());
			throw new TimesOverflowException(this.getNumerator(), factor);
		}
	}
	
	public Rational multiply2(long factor){
		return null;
	}
}
