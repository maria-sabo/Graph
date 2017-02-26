import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Created by Ma$ha on 14.02.2017.
 */
public class GraphTest {
    @Test
    public void addVertexT(){
        Graph Gr = new Graph("Gr");
        Gr.addVertex("A");
        Gr.addVertex("B");
        assertEquals(Gr.getAllVertex().toString(), "[A, B]");
        assertEquals(Gr.getTable().toString(), "[[0, 0], [0, 0]]");
    }
    @Test
    public void addEdgeT() {
        Graph Gr = new Graph("Gr");
        Gr.addEdge("A", "B", 5);
        assertEquals(Gr.getTable().toString(), "[[0, 5], [0, 0]]");
    }
    @Test
    public void changeVertexNameT() {
        Graph Gr = new Graph("Gr");
        Gr.addVertex("A");
        Gr.changeVertexName("A", "B");
        assertEquals(Gr.getAllVertex().toString(), "[B]");
    }
    @Test
    public void removeVertexT() {
        Graph Gr = new Graph("Gr");
        Gr.addVertex("A");
        Gr.removeVertex("A");
        assertEquals(Gr.getAllVertex().toString(), "[]");
    }
    @Test
    public void removeEdgeT() {
        Graph Gr = new Graph("Gr");
        Gr.addEdge("A", "B", 5);
        Gr.removeEdge("A", "B");
        assertEquals(Gr.getTable().toString(), "[[0, 0], [0, 0]]");
    }
    @Test
    public void VertexInT() {
        Graph Gr = new Graph("Gr");
        Gr.addEdge("A", "B", 5);
        Gr.addEdge("A", "C", 4);
        Gr.addEdge("A", "D", 3);
        Gr.addEdge("A", "E", 2);
        Gr.addEdge("B", "E", 2);
        assertEquals(Gr.vertexIn("A").toString(), "[]");
        assertEquals(Gr.vertexIn("E").toString(), "[A, B]");
    }
    @Test
    public void VertexOutT() {
        Graph Gr = new Graph("Gr");
        Gr.addEdge("A", "B", 5);
        Gr.addEdge("A", "C", 4);
        Gr.addEdge("A", "D", 3);
        Gr.addEdge("A", "E", 2);
        Gr.addEdge("B", "E", 2);
        assertEquals(Gr.vertexOut("A").toString(), "[B, C, D, E]");
        assertEquals(Gr.vertexOut("B").toString(), "[E]");
    }
}