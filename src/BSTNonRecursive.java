
public class BSTNonRecursive<T> {

	Node<T> root;
	
	public static void main(String[] args) {
		BSTNonRecursive<Integer> tree = new BSTNonRecursive<>();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		
		tree.printInorder(tree.root);
	}
	
	public void insert(T data) {
		Node<T> newNode = new Node<>(data);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		Node<T> currentNode = root;
		while(true) {
			if ( ((Comparable<T>)data).compareTo(currentNode.data)  < 0) {
				if (currentNode.left == null) 
				{
					currentNode.left = newNode;
					break;
				} else {
					currentNode = currentNode.left;
				}
			} else {
				if (currentNode.right == null) 
				{
					currentNode.right = newNode;
					break;
				} else {
					currentNode = currentNode.right;
				}
			}
		}
	}
	
	public void printInorder(Node<T> node) {
		if (node == null) 
			return;
		printInorder(node.left);
		System.out.println(node.data);
		printInorder(node.right);
	}

	static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;
		
		Node(T data) {
			this.data = data;
		}
	}
}
