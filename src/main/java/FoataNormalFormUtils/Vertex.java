package FoataNormalFormUtils;

public class Vertex {
    public Vertex(String label, int id) {
        this.label = label;
        this.id = id;
        visited = false;
    }

    public String getLabel() {
        return label;
    }

    public int getId() {
        return id;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    private String label;
    private int id;
    private boolean visited;


    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vertex && id == ((Vertex) obj).getId();
    }

    @Override
    public String toString() {
        return label + " " + id;
    }

}
