import java.util.TreeSet;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph extends TreeSet<Vertex> {
    public Graph() {
        super();
    }

    public void addVertex(Vertex vertex) {
        this.addVertex(vertex);
    }

    Vertex get(String name) {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Vertex vertex = (Vertex) (it.next());
            if (vertex.name.equals(name))
                return vertex;
        }
        return null;
    }

    public boolean addEdge(String nameFrom, String nameTo) {
        Vertex u = this.get(nameFrom);
        Vertex v = this.get(nameTo);
        if (u == null || v == null)
            return false;
        Edge e = new Edge(u, v, 1);
        u.adjList.add(e);
        return true;
    }

    public boolean addEdge(Vertex u, Vertex v) {
        if (u == null || v == null)
            return false;
        Edge e = new Edge(u, v, 1);
        u.adjList.add(e);
        return true;
    }

    public Graph loadFromFile(String fName) {
        Graph g = null;
        File f = new File(fName);
        if (!f.exists()) {
            System.out.println("File not found");
            System.exit(0);
            return g;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            StringTokenizer stk = null;
            line = br.readLine();
            if (line != null) {
                g = new Graph();
                stk = new StringTokenizer(line, " ");
                while (stk.hasMoreTokens()) {
                    String name = stk.nextToken();
                    Vertex v = new Vertex(name);
                    g.add(v);
                }
            }
            while ((line = br.readLine()) != null) {
                stk = new StringTokenizer(line, " ");
                String nameFrom = stk.nextToken();
                Vertex u = g.get(nameFrom);
                while (stk.hasMoreTokens()) {
                    String nameTo = stk.nextToken();
                    Vertex v = g.get(nameTo);
                    g.addEdge(u, v);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            g = null;
        }
        return g;
    }
}
