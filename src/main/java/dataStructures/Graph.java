package dataStructures;

import java.util.ArrayList;



public class Graph<T> {

    private ArrayList<Vertex<T>> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public Graph(ArrayList<Vertex<T>> vertices) {
        this.vertices = new ArrayList<>();
        this.vertices.addAll(vertices);
    }

    public void addVertices(ArrayList<Vertex<T>> vertices)  {
        this.vertices.addAll(vertices);
    }

    public Vertex<T> getFirst() {
        return get(0);
    }
    public Vertex<T> getLast() {
        return get(vertices.size() - 1);
    }

    public Vertex<T> get(int index) {
        return vertices.get(index);
    }

    public int size() {
        return vertices.size();
    }

}

