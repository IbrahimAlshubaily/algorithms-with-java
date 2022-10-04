import dataStructures.Graph;
import dataStructures.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import search.BFS;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFSTest {

    Graph graph;

    @BeforeEach
    void setUp() {
        Vertex<Character> a = new Vertex<>('a');
        Vertex<Character> b = new Vertex<>('b');
        Vertex<Character> c = new Vertex<>('c');
        Vertex<Character> d = new Vertex<>('d');
        Vertex<Character> e = new Vertex<>('e');

        a.addNeighbor(b);
        a.addNeighbor(c);

        b.addNeighbor(c);
        b.addNeighbor(d);

        c.addNeighbor(b);
        c.addNeighbor(d);
        c.addNeighbor(e);

        d.addNeighbor(e);

        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);

        graph =  new Graph(vertices);

    }

    @Test
    void testShortestPath(){
        //a -> c -> e
        assertEquals(2, BFS.ShortestPathLength(graph, graph.getFirst(), graph.getLast()));
    }


}
