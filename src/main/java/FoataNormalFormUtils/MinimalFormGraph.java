package FoataNormalFormUtils;

import Language.Dependence;
import Language.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimalFormGraph {


    private Graph graph;
    private List<String> word;
    private Dependence dependence;
    private StringBuilder foataNormalForm;

    public MinimalFormGraph(List<String> word, Dependence dependence) {
        this.graph = new Graph();
        this.word = word;
        this.dependence = dependence;
        this.foataNormalForm = new StringBuilder();
        makeMinimalFormGraph();
        calculateFoataNormalFormFromGraph();

    }

    private void makeMinimalFormGraph() {
        Collections.reverse(word);
        List<Vertex> min = new ArrayList<>();
        Vertex currentVertex;
        for (int i = 0; i < word.size(); i++) {
            currentVertex = new Vertex(word.get(i), i);
            graph.addVertex(currentVertex);
            min.add(currentVertex);
            for (Vertex v :
                    min) {
                if (!v.equals(currentVertex) && dependence.contains(new Tuple(currentVertex.getLabel(), v.getLabel()))) {
                    graph.addEdge(currentVertex, v);
                }
            }
        }
        graph.transitiveReduction();
    }


    public String getFoataNormalForm() {
        return foataNormalForm.toString();
    }

    private void calculateFoataNormalFormFromGraph() {
        List<Vertex> vertices = graph.topologicalSort();
        List<String> labels;
        Collections.reverse(vertices);
        List<Vertex> foataNormalFormStep = new ArrayList<>();
        while (!vertices.isEmpty()) {
            for (Vertex v :
                    vertices) {
                if (graph.isAdjacent(v)) {
                    foataNormalFormStep.add(v);
                }
            }
            labels = foataNormalFormStep.stream()
                    .map(Vertex::getLabel).collect(Collectors.toList());
            Collections.sort(labels);
            foataNormalForm.append("(");
            for (String letter :
                    labels) {

                foataNormalForm.append(letter);
            }
            for (Vertex u :
                    foataNormalFormStep) {
                graph.removeVertex(u);
            }
            foataNormalForm.append(")");
            vertices.removeAll(foataNormalFormStep);
            foataNormalFormStep.clear();
        }
    }
    public Graph getGraph() {
        return graph;
    }
}


