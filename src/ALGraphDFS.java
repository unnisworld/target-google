// The Graph used in example :
//
//   (A)
//    |
//   (B) - (H)
//    |     | 
//   (C) - (E) - (G)
//    |     |
//   (D)   (F)
//
// Time complexity is O(V + E).
import java.util.LinkedList;
import java.util.Stack;

public class ALGraphDFS {
	
	static class Graph {
		int maxNoOfVertices;
		LinkedList<Integer>[] adjList;
		Vertex[] vertexList;
		int noOfVertices;
		
		Graph(int v) {
			this.maxNoOfVertices = v;
			adjList = new LinkedList[v];
			vertexList = new Vertex[v];
			
			for (int i=0;i<v;i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}
		
		void addVertex(char c) {
			vertexList[noOfVertices++] = new Vertex(c);
		}
		
		void addEdge(int src, int dest) {
			adjList[src].add(dest);
			adjList[dest].add(src);
		}
		
		void dfs() {
		    Stack<Integer> vertexStack = new Stack<Integer>();
		    boolean[] visited = new boolean[noOfVertices];

		    visited[0] = true;
		    vertexStack.add(0);
		    processVertex(0);

		    while( !(vertexStack.isEmpty()) ) {
		      int v = getAdjUnvisitedVertex(vertexStack.peek(), visited);

		      if (v == -1) {
		        vertexStack.pop();
		      } else {
		        visited[v] = true;
		        processVertex(v);
		        vertexStack.push(v);
		      }
		    }

		  }

		  void processVertex(int v) {
		    System.out.print(vertexList[v] + "-->");
		  }
		  
		  int getAdjUnvisitedVertex(int vertex, boolean[] visited) {
			  
			  for(int i : adjList[vertex]) {
				  if (visited[i] == false) {
					  return i;
				  }
			  }
			  
			  return -1;
		  }
	}
	
	static class Vertex {
		  char label;

		  public Vertex(char l) {
		    this.label = l;
		  }

		  public String toString() {
		    return "(" + label + ")";
		  }
	}
	
	public static void main(String[] args) {
		    Graph g = new Graph(8);
		    g.addVertex('A'); // 0
		    g.addVertex('B'); // 1
		    g.addVertex('C'); // 2
		    g.addVertex('D'); // 3
		    g.addVertex('E'); // 4
		    g.addVertex('F'); // 5
		    g.addVertex('G'); // 6
		    g.addVertex('H'); // 7

		    g.addEdge(0, 1); // A - B
		    g.addEdge(1, 2); // B - C
		    g.addEdge(2, 3); // C - D
		    g.addEdge(4, 5); // E - F

		    g.addEdge(1, 7); // B - H
		    g.addEdge(2, 4); // C - E
		    g.addEdge(7, 4); // H - E
		    g.addEdge(4, 6); // E - G

		    g.dfs();
	}
}
