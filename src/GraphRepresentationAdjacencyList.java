import java.util.LinkedList;

public class GraphRepresentationAdjacencyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5; 
        Graph graph = new Graph(V); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 4); 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        graph.printGraph(); 
	}
	
	static class Graph {
		int numVertices;
		LinkedList<Integer>[] adjacentListArray;
		
		Graph(int v) {
			this.numVertices = v;
			
			adjacentListArray = new LinkedList[v];
			
			for(int i=0;i<v;i++) {
				adjacentListArray[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int src, int dest) {
			this.adjacentListArray[src].add(dest);
			this.adjacentListArray[dest].add(src);
		}
		
		void printGraph() {
			for (int i=0;i<numVertices;i++) {
				System.out.println("Adjacency list of vertex "+ i);
				
				for(Integer v : adjacentListArray[i]) {
					System.out.print("-> "+ v);
				}
				System.out.println("\n");
			}
		}
 	}

}
