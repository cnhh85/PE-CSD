import java.util.ArrayList;

public class TestGraph1 {
    public static void main(String[] args) {
        Graph g = new Graph();
        g = g.loadFromFile("graph1.txt");
        System.out.println(g.toString());
        ArrayList<Edge> edges = g. depthFirstSearch();
        System.out.println("Depth First Search: ");
        g.printEdges(edges, System.out);
        edges = g.breadFirstSearch();
        System.out.println("Bread First Search: ");
        g.printEdges(edges, System.out);
    }
}
