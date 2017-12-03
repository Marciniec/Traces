package FoataNormalFormUtils;

import Language.Dependence;
import Language.Tuple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimalFormGraphTest {
    private List<Edge> minimalGraphEdges;
    private Dependence dependence;
    private List<String > word;

    private void init(){
        dependence = new Dependence();
        dependence = new Dependence();
        List<Tuple> dependencyList = Arrays.asList(new Tuple("a", "a"),
                new Tuple("a", "b"), new Tuple("a", "c"), new Tuple("b", "a"),
                new Tuple("b", "b"), new Tuple("b", "d"), new Tuple("c", "a"),
                new Tuple("c", "c"), new Tuple("c", "d"), new Tuple("d", "b"),
                new Tuple("d", "c"), new Tuple("d", "d"));
        dependence.setDependenceList(dependencyList);
        word = Arrays.asList("baadcb".split(""));
        minimalGraphEdges = new ArrayList<>(Arrays.asList(new Edge(
                new Vertex("d",2), new Vertex("b", 0)),
                new Edge(
                        new Vertex("d",2), new Vertex("c", 1)),
                new Edge(
                        new Vertex("a",3), new Vertex("b", 0)),
                new Edge(
                        new Vertex("a",3), new Vertex("c", 1)),
                new Edge(
                        new Vertex("a",4), new Vertex("a", 3)),
                new Edge(
                        new Vertex("b",5), new Vertex("d", 2)),
                new Edge(
                        new Vertex("b",5), new Vertex("a", 4))));


    }
    @Test
    public void makeMinimalFormGraphTest(){
        init();
        MinimalFormGraph computedMinimalFormGraph = new MinimalFormGraph(word,dependence);
        Graph computedGraph = computedMinimalFormGraph.getGraph();
        assert computedGraph.getEdges().containsAll(minimalGraphEdges);
        assert minimalGraphEdges.containsAll(computedGraph.getEdges());
    }
    @Test
    public void calculateFoataNormalFormFromGraphTest(){
        init();
        MinimalFormGraph computedMinimalFormGraph = new MinimalFormGraph(word,dependence);
        computedMinimalFormGraph.getFoataNormalForm().equals("(b)(ad)(a)(bc)");
    }
}
