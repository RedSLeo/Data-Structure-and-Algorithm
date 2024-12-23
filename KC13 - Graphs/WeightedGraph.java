//----------------------------------------------------------------------------
// WeightedGraph.java            by Dale/Joyce/Weems                Chapter 10
//
// Implements a directed graph with weighted edges.
// Vertices are objects of class T and can be marked as having been visited.
// Edge weights are integers.
// Equivalence of vertices is determined by the vertices' equals method.
//
// General precondition: Except for the addVertex and hasVertex methods, 
// any vertex passed as an argument to a method is in this graph.
//----------------------------------------------------------------------------

// package ch10.graphs;
package graphs;

// import java.util.LinkedList;
// import java.util.Map;
// import java.util.Queue;
// import java.util.HashMap;
import java.util.*;

import ch04.queues.*;
import ch09.priorityQueues.HeapPriQ;
import ch09.priorityQueues.PriQueueInterface;
import support.Flight;

public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
  public static final int NULL_EDGE = 0;
  private static final int DEFCAP = 50;  // default capacity
  private int numVertices;
  private int maxVertices;
  private T[] vertices;
  private int[][] edges;
  private boolean[] marks;  // marks[i] is mark for vertices[i]

  public WeightedGraph()
  // Instantiates a graph with capacity DEFCAP vertices.
  {
    numVertices = 0;
    maxVertices = DEFCAP;
    vertices = (T[]) new Object[DEFCAP];
    marks = new boolean[DEFCAP];
    edges = new int[DEFCAP][DEFCAP];
  }
 
  public WeightedGraph(int maxV)
  // Instantiates a graph with capacity maxV.
  {
    numVertices = 0;
    maxVertices = maxV;
    vertices = (T[]) new Object[maxV];
    marks = new boolean[maxV];
    edges = new int[maxV][maxV];
  }

  public boolean isEmpty()
  // Returns true if this graph is empty; otherwise, returns false.
  {
    return numVertices == 0;
  }

  public boolean isFull()
  // Returns true if this graph is full; otherwise, returns false.
  {
    return numVertices == maxVertices;
  }

  public void addVertex(T vertex)
  // Preconditions:   This graph is not full.
  //                  vertex is not already in this graph.
  //                  vertex is not null.
  //
  // Adds vertex to this graph.
  {
    vertices[numVertices] = vertex;
    for (int index = 0; index < numVertices; index++)
    {
      edges[numVertices][index] = NULL_EDGE;
      edges[index][numVertices] = NULL_EDGE;
    }
    numVertices++;
  }

  public boolean hasVertex(T vertex)
  // Returns true if this graph contains vertex; otherwise, returns false.
  {
    for (int i = 0; i < numVertices; i++) {
      if (vertices[i].equals(vertex)) {
        return true;
      }
    }
    return false;
  }
  
  private int indexIs(T vertex)
  // Returns the index of vertex in vertices.
  {
    int index = 0;
    while (!vertex.equals(vertices[index]))
      index++;
    return index;
  }

  public void addEdge(T fromVertex, T toVertex, int weight)
  // Adds an edge with the specified weight from fromVertex to toVertex.
  {
    int row;
    int column;
 
    row = indexIs(fromVertex);
    column = indexIs(toVertex);
    edges[row][column] = weight;
  }

  public int weightIs(T fromVertex, T toVertex)
  // If edge from fromVertex to toVertex exists, returns the weight of edge;
  // otherwise, returns a special �null-edge� value.
  {
    int row;
    int column;
 
    row = indexIs(fromVertex);
    column = indexIs(toVertex);
    return edges[row][column];
  }

  public QueueInterface<T> getToVertices(T vertex)
  // Returns a queue of the vertices that vertex is adjacent to.
  {
    QueueInterface<T> adjVertices = new LinkedQueue<T>();
    int fromIndex;
    int toIndex;
    fromIndex = indexIs(vertex);
    for (toIndex = 0; toIndex < numVertices; toIndex++)
      if (edges[fromIndex][toIndex] != NULL_EDGE)
        adjVertices.enqueue(vertices[toIndex]);
    return adjVertices;
  }

  public void clearMarks()
  // Unmarks all vertices.
  {
    for (int i = 0; i < numVertices; i++) {
      marks[i] = false;
    }
  }

  public void markVertex(T vertex)
  // Marks vertex.
  {
    int index = indexIs(vertex);
    if (index >= 0) {
      marks[index] = true;
    }
  }

  public boolean isMarked(T vertex)
  // Returns true if vertex is marked; otherwise, returns false.
  {
    int index = indexIs(vertex);
    if (index >= 0) {
      return marks[index];
    }
    return false;
  }
  
  public T getUnmarked()
  // Returns an unmarked vertex if any exist; otherwise, returns null.
  {
    for (int i = 0; i < numVertices; i++) {
      if (!marks[i]) {
        return vertices[i];
      }
    }
    return null;
  }
  
  /**
   * 
   * Checks to see if an edge exists between two vertices in the graphs
   * 
   * @param vertex1 first vertex
   * @param vertex2 second vertex
   * @return true if there is an edge connecting vertex1 and vertex2, otherwise false.
   */
  public boolean edgeExists(T vertex1, T vertex2)
  // Preconditions:  vertex1 and vertex2 are in the set of vertices
  //
  // Return value = (vertex1, vertex2) is in the set of edges
  {
    int index1 = indexIs(vertex1);
    int index2 = indexIs(vertex2);

    if (index1 == -1 || index2 == -2) {
      return false;
    }
    return (edges[indexIs(vertex1)][indexIs(vertex2)] != NULL_EDGE);
  }

  public boolean removeEdge(T vertex1, T vertex2)
  // Preconditions:  vertex1 and vertex2 are in the set of vertices
  //
  // Return value = true if edge was in the graph (and has been removed)
  //              = false if edge was not in the graph
  {
    boolean existed = edgeExists(vertex1, vertex2);
    edges[indexIs(vertex1)][indexIs(vertex2)] = NULL_EDGE;
    return existed;
  }

  /**
   * 
   * Counts the number of vertices that are connected to both vertex a and b
   * 
   * Precondition: Both vertex a and b are guarenteed to exist in the graph
   * 
   * @param a The first vertex
   * @param b The second vertex
   * @return The number of vertices that are connected to both vertex a and b
   */
  public int connects(T a, T b) {
    int indexA = indexIs(a);
    int indexB = indexIs(b);

    int count = 0;

    for (int i = 0; i < numVertices; i++) {
      if (edges[indexA][i] != NULL_EDGE && edges[indexB][i] != NULL_EDGE) {
        count++;
      }
    }
    return count;
  }

  public static int minEdges(WeightedGraphInterface<String> graph, String startVertex, String endVertex) {
    Flight flight;
    Flight saveFlight; // For saving on priority queue
    int edgeCount;     // Number of edges
    String vertex;

    QueueInterface<String> vertexQueue = new LinkedQueue<String>();
    PriQueueInterface<Flight> pq = new HeapPriQ<Flight>(20);

    graph.clearMarks();
    saveFlight = new Flight(startVertex, startVertex, 0);
    pq.enqueue(saveFlight);

    do {
        flight = pq.dequeue();
        if (!graph.isMarked(flight.getToVertex())) {
            graph.markVertex(flight.getToVertex());
            
          
            if (flight.getToVertex().equals(endVertex)) {
                return flight.getDistance();
            }

            edgeCount = flight.getDistance();
            vertexQueue = graph.getToVertices(flight.getToVertex());
            while (!vertexQueue.isEmpty()) {
                vertex = vertexQueue.dequeue();
                if (!graph.isMarked(vertex)) {
                    saveFlight = new Flight(flight.getToVertex(), vertex, edgeCount + 1);
                    pq.enqueue(saveFlight);
                }
            }
        }
    } while (!pq.isEmpty());

    return -1;
}
  
}
