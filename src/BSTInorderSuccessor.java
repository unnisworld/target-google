
// https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
public class BSTInorderSuccessor {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Node n20 = new Node(20);
		tree.insert(n20);
		Node n8 = new Node(8);
		tree.insert(n8);
		Node n22 = new Node(22);
		tree.insert(n22);
		Node n4 = new Node(4);
		tree.insert(n4);
		Node n12 = new Node(12);
		tree.insert(n12);
		Node n10 = new Node(10);
		tree.insert(n10);
		Node n14 = new Node(14);
		tree.insert(n14);

		tree.printInOrder();

		assertEquals(20, tree.getInOrderSuccessor(n14).data);

		assertEquals(10, tree.getInOrderSuccessor(n8).data);

		assertEquals(12, tree.getInOrderSuccessor(n10).data);
	}

	private static boolean assertEquals(int expected, int actual) {
		if (expected == actual)
			return true;
		else
			throw new RuntimeException("Assertion failed. Expected " + expected + ", Actual " + actual);

	}

}

class Node {
	int data;
	Node left, right, parent;

	Node(int data) {
		this.data = data;
	}
}

class BinarySearchTree {
	Node head;

	void insert(Node newNode) {
		head = insertInternal(head, newNode);
	}

	void printInOrder() {
		printInOrderInternal(head);
	}

	Node getInOrderSuccessor(Node n) {
		if (n.right != null) {
			return getMinValue(n.right);
		}

		Node parentNode = n;
		Node grandParentNode = parentNode.parent;
		while (grandParentNode != null) {

			if (grandParentNode.left == parentNode) {
				return grandParentNode;
			}

			parentNode = grandParentNode;
			grandParentNode = parentNode.parent;
		}

		// We couldn't find matching node.
		return null;
	}

	private Node getMinValue(Node subTreeRoot) {

		if (subTreeRoot.left == null)
			return subTreeRoot;

		return getMinValue(subTreeRoot.left);
	}

	private Node insertInternal(Node subTreeRoot, Node newNode) {

		if (subTreeRoot == null) {
			subTreeRoot = newNode;

			return subTreeRoot;
		}

		if (newNode.data <= subTreeRoot.data) {
			Node insertedNode = insertInternal(subTreeRoot.left, newNode);
			subTreeRoot.left = insertedNode;
			insertedNode.parent = subTreeRoot;
		} else {
			Node insertedNode = insertInternal(subTreeRoot.right, newNode);
			subTreeRoot.right = insertedNode;
			insertedNode.parent = subTreeRoot;
		}

		return subTreeRoot;
	}

	private void printInOrderInternal(Node subTreeRoot) {

		if (subTreeRoot == null) {
			return;
		}

		printInOrderInternal(subTreeRoot.left);
		System.out.println(subTreeRoot.data);
		printInOrderInternal(subTreeRoot.right);
	}

}
