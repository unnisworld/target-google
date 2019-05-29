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
// Time complexity is O(v^2) as adjacency matrix is used to represent the Graph.
import java.util.Stack;

class Vertex {
  char label;

  public Vertex(char l) {
    this.label = l;
  }

  public String toString() {
    return "(" + label + ")";
  }
}

class Graph {
  int maxVertexCount = 20;
  Vertex[] vertexList;
  int adjMatrix[][];
  int vertexCount;

  Graph() {
    vertexList = new Vertex[maxVertexCount];
    adjMatrix = new int[maxVertexCount][maxVertexCount];

    for (int i=0;i<maxVertexCount;i++) {
      for(int j=0;j<maxVertexCount;j++) {
        adjMatrix[i][j] = 0;
      }
    }

  }

  void addVertex(char l) {
    vertexList[vertexCount++] = new Vertex(l);
  }

  void addEdge(int start, int dest) {
    adjMatrix[start][dest] = 1;
    adjMatrix[dest][start] = 1;
  }

  void dfs() {
    Stack<Integer> vertexStack = new Stack<Integer>();
    boolean[] visited = new boolean[vertexCount];

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

  int getAdjUnvisitedVertex(int v, boolean[] visited) {
    for(int j=0;j<vertexCount;j++) {
      if (adjMatrix[v][j] == 1 && visited[j] == false ) {
        return j;
      }
    }

    return -1;
  }

}

public class GraphDFS {
  public static void main(String[] args) {
    Graph g = new Graph();
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