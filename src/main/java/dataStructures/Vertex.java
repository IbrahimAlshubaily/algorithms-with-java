package dataStructures;

import java.util.ArrayList;

public class Vertex<T> {
    private final T value;
    private final ArrayList<Vertex<T>> neighbors;

    public Vertex(T value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Vertex<T> neighbor) {
        this.neighbors.add(neighbor);
    }

    public ArrayList<Vertex<T>> getNeighbors() {
        return neighbors;
    }
}
