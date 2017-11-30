package Language;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dependence {
    private List<Tuple> dependenceList;


    public void computeDependency(List<Tuple> independence, List<Tuple> cartesianProductOfAlphabet) {
        cartesianProductOfAlphabet.removeAll(independence);
        dependenceList = cartesianProductOfAlphabet;
        System.out.println(dependenceList);
    }

    public List<String> retrieveAllDependentTo(String x) {
        return dependenceList.stream().
                filter(tuple -> tuple.getX().equals(x)).map(Tuple::getY)
                .collect(Collectors.toList());

    }

}
