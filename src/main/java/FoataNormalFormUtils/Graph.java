package FoataNormalFormUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    void addEdge(Vertex v1, Vertex v2) {
        edges.add(new Edge(v1, v2));
    }


    public void transitiveReduction() {
        List<Vertex> neighbourVertices;
        for (Vertex vertex :
                vertices) {
            neighbourVertices = edges.stream().filter(edge -> edge.getV1().equals(vertex)).map(Edge::getV2).collect(Collectors.toList());
            for (Vertex neighbour :
                    neighbourVertices) {
                dfs(neighbour);
                for (Vertex v :
                        vertices) {
                    if (v.isVisited() && !v.equals(neighbour)) {
                        List<Edge> e = edges.stream()
                                .filter(edge -> edge.getV2().equals(v) && edge.getV1().equals(vertex))
                                .collect(Collectors.toList());
                        edges.removeAll(e);
                    }
                }
                vertices.forEach(vertex1 -> vertex1.setVisited(false));
            }
        }

    }

    private void dfs(Vertex startVertex) {
        startVertex.setVisited(true);
        List<Edge> adjacentEdges = edges.stream().filter(edge -> edge.getV1().equals(startVertex)).collect(Collectors.toList());
        for (Edge e :
                adjacentEdges) {
            if (!e.getV2().isVisited()) dfs(e.getV2());
        }
    }

    public List<Vertex> topologicalSort() {
        List<Vertex> sorted = new ArrayList<>();
        while (!allVisited()) {
            for (Vertex v :
                    vertices) {
                if (!v.isVisited()) {
                    visit(v, sorted);
                }
            }
        }

        return sorted;
    }

    private void visit(Vertex vertex, List<Vertex> sorted) {
        vertex.setVisited(true);
        List<Edge> adjacentEdges =
                edges.stream().filter(edge -> edge.getV1().equals(vertex))
                        .collect(Collectors.toList());
        for (Edge e :
                adjacentEdges) {
            if (!e.getV2().isVisited()) visit(e.getV2(), sorted);
        }
        sorted.add(vertex);


    }

    private boolean allVisited() {
        for (Vertex v :
                vertices) {
            if (!v.isVisited()) return false;
        }
        return true;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void removeVertex(Vertex vertex){
        List<Edge> edgesToRemove = edges.stream().filter(edge ->
        edge.getV1().equals(vertex)).collect(Collectors.toList());
        edges.removeAll(edgesToRemove);
        vertices.remove(vertex);
    }
    public boolean isAdjacent(Vertex vertex){
        return edges.stream().noneMatch(edge -> edge.getV2().equals(vertex))  ||( edges.isEmpty() && vertices.contains(vertex));
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Edge e :
                edges) {
            sb.append(e.toString()).append(" ");
        }
        return sb.toString();
    }

}
