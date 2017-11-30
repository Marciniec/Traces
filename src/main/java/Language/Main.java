package Language;

import FoataNormalFormUtils.FoataNormalForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.addAll(Arrays.asList("a", "b", "c", "d"));
        Alphabet alphabet = new Alphabet(a);
        System.out.println(a);
        System.out.println(alphabet);
        Independence independence = new Independence(Arrays.asList(new Tuple("a", "d"),
                new Tuple("d", "a"), new Tuple("b", "c"), new Tuple("c", "b")));
        Dependence dependence = new Dependence();
        dependence.computeDependency(independence.getIndependenceList(), alphabet.getCartesianProduct());
        FoataNormalForm foataNormalForm = new FoataNormalForm(Arrays.asList("baadcb".split("")),dependence );
        System.out.println(foataNormalForm.getFoataSteps());
    }
}
