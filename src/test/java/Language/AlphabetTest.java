package Language;

import org.junit.Test;

import java.util.*;

public class AlphabetTest {
    @Test
    public void cartesianProductTest() {
        Alphabet alphabet = new Alphabet(Arrays.asList("a", "b", "c"));
        List<Tuple> cartesianProduct = new ArrayList<>(Arrays.asList(new Tuple("a", "a"),
                new Tuple("a", "b"), new Tuple("a", "c"), new Tuple("b", "a"),
                new Tuple("b", "b"), new Tuple("b", "c"), new Tuple("c", "a"),
                new Tuple("c", "b"), new Tuple("c", "c")));
        List<Tuple> computedCartesianProduct = alphabet.getCartesianProduct();
        assert cartesianProduct.containsAll(computedCartesianProduct);
        assert computedCartesianProduct.containsAll(cartesianProduct);
    }
}
