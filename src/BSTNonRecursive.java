import java.util.Stack;

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
		
		//tree.printInorder(tree.root);
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
	
	public void printInorderRecursive(Node<T> node) {
		if (node == null) 
			return;
		printInorderRecursive(node.left);
		System.out.println(node.data);
		printInorderRecursive(node.right);
	}

	public void printInorder(Node<T> root) {
		if (root == null)
			return;
		
		Stack<T> stack = new Stack<>();
		Node<T> current = root.right;
		while(true) {
			if (current == null) {
				break;
			}
			stack.push(current.data);
			current = current.right;
		}
		stack.push(root.data);
		current = root.left;
		while(true) {
			if (current == null) {
				break;
			}
			stack.push(current.data);
			current = current.left;
		}
		
		while (!stack.isEmpty())
			System.out.println(stack.pop());
		
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
