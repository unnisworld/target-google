import java.util.Queue; 
import java.util.LinkedList; 
	
public class BSTFindLevelOfNode {
	
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1);           // level 0
		tree.root.left = new Node(2);      // level 1
		tree.root.right = new Node(3);     // level 1
		tree.root.left.left = new Node(4); // level 2
		tree.root.left.right = new Node(5); // level 2
		tree.root.left.left.left = new Node(6); // level 3
		tree.root.left.left.right = new Node(7); // level 3
		
		System.out.println("Level :" + tree.findLevel(5));
		
	} 
	
	static class Node { 
		int data; 
		Node left, right; 

		public Node(int item) { 
			data = item; 
			left = null; 
			right = null; 
		} 
	} 

	static class BinaryTree { 

		Node root;
		
		int findLevel(int nodeValue) 
		{ 
			Queue<Node> queue = new LinkedList<Node>(); 
			queue.add(root);
			queue.add(null);
			int level = 0;
			while (!queue.isEmpty()) 
			{ 
				Node tempNode = queue.poll(); 
				
				if (tempNode == null) {
					level ++;
					queue.add(null);
					continue;
				}
				
				System.out.print(tempNode.data + " ");
				
				if (tempNode.data == nodeValue) {
					return level;
				}

				// Enqueue left child
				if (tempNode.left != null) { 
					queue.add(tempNode.left); 
				} 

				// Enqueue right child
				if (tempNode.right != null) { 
					queue.add(tempNode.right); 
				}
				
			} 
			
			return -1;
		}


	} 

}
