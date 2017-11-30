package Language;

import java.util.List;

public class Dependence {
    private List<Tuple> dependenceList;


    public void computeDependency(List<Tuple> independence, List<Tuple> cartesianProductOfAlphabet) {
        cartesianProductOfAlphabet.removeAll(independence);
        dependenceList = cartesianProductOfAlphabet;
        System.out.println(dependenceList);
    }

}
