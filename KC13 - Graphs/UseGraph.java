

import graphs.WeightedGraph;

public class UseGraph {
    public static void main(String[] args) {

        WeightedGraph<String> graph = new WeightedGraph<>(5);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 3);

        System.out.println("Graph is currently empty: " + graph.isEmpty());
        System.out.println("Graph is currently full: " + graph.isFull());

        System.out.println("Vertex A is within the graph: " + graph.hasVertex("A"));
        System.out.println("Vertex D is within the graph: " + graph.hasVertex("D"));
        System.out.println("Vertex E is within the graph: " + graph.hasVertex("E"));

        System.out.println("Edge exists between A and B: " + graph.edgeExists("A", "B"));
        System.out.println("Edge exists between B and C: " + graph.edgeExists("B", "C"));

        System.out.println("Vertices connected to A and B: " + graph.connects("A", "B"));

        System.out.println("Minimum edges between A and C: " + WeightedGraph.minEdges(graph, "A", "B"));
        System.out.println("Minimum edges between C and B: " + WeightedGraph.minEdges(graph, "C", "B"));


        graph.clearMarks();
        graph.markVertex("A");
        System.out.println("Vertex A is marked: " + graph.isMarked("A"));
        System.out.println("Unmarked vertex: " + graph.getUnmarked());
    }

}