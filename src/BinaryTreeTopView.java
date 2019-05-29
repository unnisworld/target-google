import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeTopView {
	
	public static void topView(Node root, int hd) {
		Queue<NodeHdPair> q = new LinkedList<NodeHdPair>();
		Map<Integer, Node> pastNodes = new HashMap<Integer, Node>();
		
		q.add(new NodeHdPair(root, hd));
		
		while(!q.isEmpty()) {
			NodeHdPair n = q.remove();
			if (pastNodes.containsKey(n.hd)) {
				
			} else {
				System.out.println(n.node.data);
				pastNodes.put(n.hd, n.node);
			}
			
			if (n.node.left != null)
				q.add(new NodeHdPair(n.node.left ,n.hd - 1));
			
			if (n.node.right != null)
				q.add(new NodeHdPair(n.node.right, n.hd + 1));
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		topView(root, 0);
	}
	
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int d) {
			data = d;
		}
	}
	
	static class NodeHdPair {
		int hd;
		Node node;
		
		NodeHdPair(Node n, int h) {
			node = n;
			hd = h;
		}
	}

}
