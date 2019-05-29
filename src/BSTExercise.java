
// https://www.sanfoundry.com/java-program-implement-binary-search-tree-using-linked-list/
public class BSTExercise {
	
	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		
		tree.printInOrder(tree.root);
	}

	static class Node {
		Node(int data) {
			this.data = data;
		}
		int data;
		Node left;
		Node right;
	}

	static class BST {
		Node root;
		
		void insert(int data) {
			root = insertInternal(root, data);
		}
		
		private Node insertInternal(Node node, int data) {
			if (node == null) {
				node = new Node(data);
				return node;
			}
			
			if (data > node.data) {
				node.right = insertInternal(node.right, data);
			} else {
				node.left = insertInternal(node.left, data);
			}
			
			return node;
		}
		
		public void printInOrder(Node node) {
			
			if (node == null) {
				return;
			}
			printInOrder(node.left);
			System.out.println(node.data);
			printInOrder(node.right);
		}
	}

}
