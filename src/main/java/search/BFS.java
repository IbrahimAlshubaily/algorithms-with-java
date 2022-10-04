package search;

import dataStructures.Graph;
import dataStructures.Vertex;

import java.util.*;

public class BFS {

    public static int ShortestPathLength(Graph graph, Vertex start, Vertex end) {


        Set<Vertex> visited = new HashSet<>();
        HashMap<Vertex, Vertex> path = new HashMap<>();

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            Vertex curr = queue.remove();

            if (curr.equals(end)) break;

            List<Vertex> neighbors = curr.getNeighbors();
            for (Vertex neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    path.put(neighbor, curr);
                    visited.add(neighbor);
                }
            }
        }
        if (!path.containsKey(end)) return -1;

        int minDist = 0;
        Vertex curr = end;
        while (!curr.equals(start)) {

            curr = path.get(curr);
            minDist++;
        }
        return minDist;
    }
}
