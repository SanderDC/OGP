package dynamicBinding;

public class Experiment {

	public static void main(String[] args) {
		Number left = new Number(5);
		Number right = new Number(10);
		Addition addition = new Addition(left,right);
		System.out.println(addition.getValue());
	}

}
