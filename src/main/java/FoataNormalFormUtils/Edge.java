package FoataNormalFormUtils;

public class Edge {
    private Vertex v1;
    private Vertex v2;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    @Override
    public String toString() {
        return String.format("(%s -> %s)",v1, v2);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Edge && ((Edge) obj).getV2().equals(v2) && ((Edge) obj).getV1().equals(v1);
    }
}
