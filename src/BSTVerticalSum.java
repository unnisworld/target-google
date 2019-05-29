import java.util.HashMap;
import java.util.Set;

// https://www.techiedelight.com/find-vertical-sum-given-binary-tree/
public class BSTVerticalSum {
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
		
		HashMap<Integer, Integer> sumMap = tree.verticalSum();
		
		Set<Integer> keys = sumMap.keySet();
		
		for(Integer key : keys) {
			System.out.println("Distance "+ key + ", Vertical Sum "+ sumMap.get(key));
		}
		
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
		
		HashMap<Integer, Integer> verticalSum() {
			HashMap<Integer, Integer> map = new HashMap<>();
			verticalSum(root, 0, map);
			
			return map;
		}

		void verticalSum(Node root, int dist, HashMap<Integer, Integer> map) {
			
			if (root == null)
				return;
			
			if (map.get(dist) == null) {
				map.put(dist, root.data);
			} else {
				map.put(dist, map.get(dist) + root.data);
			}
			
			verticalSum(root.left, dist - 1, map);
			verticalSum(root.right, dist + 1, map);
		}
	} 

}
