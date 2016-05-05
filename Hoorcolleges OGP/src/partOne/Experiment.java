package partOne;
import java.util.Scanner;

public class Experiment {

	public static void main(String[] args) {
		Rational rat = null;
		while (rat == null){
			try{
				@SuppressWarnings("resource")
				Scanner inputScanner = new Scanner(System.in);
				long numerator = inputScanner.nextLong();
				long denominator = inputScanner.nextLong();
				rat = new Rational(numerator, denominator);
				System.out.println(ExtMath.gcd(Math.abs(rat.getDenominator()), Math.abs(rat.getNumerator())));
			} catch(IllegalDenominatorException exc) {
				System.out.println("Foute noemer!");
			}
		}
	}
}
