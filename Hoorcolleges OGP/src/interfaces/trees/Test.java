package interfaces.trees;

public class Test {

	public static void main(String[] args) {
		Integer test = new Integer(5);
		Integer test2 = new Integer(6);
		Integer test3 = new Integer(7);
		Integer test4 = new Integer(8);
		Integer test5 = new Integer(9);
		IBinaryTree boom = new LeafBinaryTree(test);
		boom = boom.addElement(test2);
		boom = boom.addElement(test3);
		boom = boom.addElement(test4);
		ComposedBinaryTree result = (ComposedBinaryTree) boom;
		System.out.println(result.getRootElement());
		System.out.println(((ComposedBinaryTree) result.getLeftTree()).getRootElement());
		System.out.println(((LeafBinaryTree) result.getRightTree()).getRootElement());
		System.out.println();
	}

}
