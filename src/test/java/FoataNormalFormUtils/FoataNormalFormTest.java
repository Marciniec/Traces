package FoataNormalFormUtils;

import Language.Dependence;
import Language.Tuple;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FoataNormalFormTest {
    private String foataNormalForm;
    private List<String> word;
    private Dependence dependence;

    private void initTest() {
        foataNormalForm = "(b)(ad)(a)(bc)";
        word = Arrays.asList("baadcb".split(""));
        dependence = new Dependence();
        List<Tuple> dependencyList = Arrays.asList(new Tuple("a", "a"),
                new Tuple("a", "b"), new Tuple("a", "c"), new Tuple("b", "a"),
                new Tuple("b", "b"), new Tuple("b", "d"), new Tuple("c", "a"),
                new Tuple("c", "c"), new Tuple("c", "d"), new Tuple("d", "b"),
                new Tuple("d", "c"), new Tuple("d", "d"));
        dependence.setDependenceList(dependencyList);
    }

    @Test
    public void computeFoataNormalFormStepsTest() {
        initTest();
        FoataNormalForm computedFNF = new FoataNormalForm(word, dependence);
        assert computedFNF.getFoataSteps().equals(foataNormalForm);
    }
}
