// Based on - https://www.baeldung.com/java-dijkstra
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DijkstrasAlgorithm {

	public static void main(String[] args) {
		
//
//          (B)---- 15 ---- (F)
//		    /  \	       /   \
//		  10	12      1        5
//		 /        \   /            \
//    (A)		   (D) ---- 2 ----- (E)
//		 \         					 |	
//		  15        				 |
//		    \    					 |
//           (C) ---- 10 -------------
//		
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D"); 
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		 
		nodeA.addAdjacentNode(nodeB, 10);
		nodeA.addAdjacentNode(nodeC, 15);
		 
		nodeB.addAdjacentNode(nodeD, 12);
		nodeB.addAdjacentNode(nodeF, 15);
		 
		nodeC.addAdjacentNode(nodeE, 10);
		 
		nodeD.addAdjacentNode(nodeE, 2);
		nodeD.addAdjacentNode(nodeF, 1);
		 
		nodeF.addAdjacentNode(nodeE, 5);
		 
		Graph graph = new Graph();
		 
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);	
		
		calculateShortestPath(graph, nodeA);
		
		for(Node node : nodeE.shortestPath) {
			System.out.print(node + "->");
		}
	}
	
	// Algorithm :
	//  - At first distance from source node to all nodes are considered to be infinity.
	//  - The algorithm starts from the source node and updates the distance (from source) of its adjacent nodes.
	//  - Among the adjacent nodes it picks the node with the shortest distance 
	private static void calculateShortestPath(Graph g, Node source) {
		Set<Node> unsettledNodes = new HashSet<>();
		Set<Node> settledNodes = new HashSet<>();
		
		source.distance = 0;
		unsettledNodes.add(source);
		
		while( !(unsettledNodes.isEmpty()) ) {
			Node currentNode = getLowestDistanceNode(unsettledNodes);
			
			// process adjacent nodes of this node.
			for(Entry<Node, Integer> entry : currentNode.adjList.entrySet()) {
				Node adjacentNode = entry.getKey();
				int edgeWeight = entry.getValue();
				updateShortestPathAndDistance(adjacentNode, edgeWeight, currentNode);
				
				unsettledNodes.add(adjacentNode);
			}
			
			unsettledNodes.remove(currentNode);
			settledNodes.add(currentNode);
		}
		
	}
	
	private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistancenNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		
		for(Node node : unsettledNodes) {
			if (node.distance < lowestDistance) {
				lowestDistance = node.distance;
				lowestDistancenNode = node;
			}
		}
		
		return lowestDistancenNode;
	}
	
	private static void updateShortestPathAndDistance(Node adjacentNode, int edgeWeight, Node currentNode) {
		if (currentNode.distance + edgeWeight < adjacentNode.distance) {
			adjacentNode.distance = currentNode.distance + edgeWeight;
			adjacentNode.shortestPath = new LinkedList<>(currentNode.shortestPath);
			adjacentNode.shortestPath.add(currentNode);
		}
	}
	
	static class Graph {
		Set<Node> nodes = new HashSet<>();
		
		void addNode(Node node) {
			nodes.add(node);
		}
	}
	
	static class Node {
		String name;
		Map<Node, Integer> adjList = new HashMap<>();
		List<Node> shortestPath = new LinkedList<Node>();
		Integer distance = Integer.MAX_VALUE;
		
		void addAdjacentNode(Node node, int distance) {
			adjList.put(node, distance);
		}
		
		Node(String name) {
			this.name = name;
		}
		
		public String toString() {
			return "(" + name + ")";
		}
	}

}
