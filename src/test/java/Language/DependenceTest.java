package Language;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DependenceTest {
    private Alphabet alphabet = new Alphabet(Arrays.asList("a", "b", "c", "d"));
    private Dependence dependence = new Dependence();
    private Independence independence = new Independence(Arrays.asList(new Tuple("a", "d"), new Tuple("d", "a"),
            new Tuple("b", "c"), new Tuple("c", "b")));

    @Test
    public void computingDependencyTest() {
        List<Tuple> dependencyList = Arrays.asList(new Tuple("a", "a"),
                new Tuple("a", "b"), new Tuple("a", "c"), new Tuple("b", "a"),
                new Tuple("b", "b"), new Tuple("b", "d"), new Tuple("c", "a"),
                new Tuple("c", "c"), new Tuple("c", "d"), new Tuple("d", "b"),
                new Tuple("d", "c"), new Tuple("d", "d"));
        dependence.computeDependency(independence.getIndependenceList(), alphabet.getCartesianProduct());
        List<Tuple> computedDependency = dependence.getDependenceList();
        assert dependencyList.containsAll(computedDependency);
        assert computedDependency.containsAll(dependencyList);
    }

    @Test
    public void retrieveAllDependentToTest() {
        List<String> dependentTo = Arrays.asList("a", "b", "c");
        dependence.computeDependency(independence.getIndependenceList(), alphabet.getCartesianProduct());
        List<String> computedDependentTo = dependence.retrieveAllDependentTo("a");
        assert dependentTo.containsAll(computedDependentTo);
        assert computedDependentTo.containsAll(dependentTo);
    }
}
