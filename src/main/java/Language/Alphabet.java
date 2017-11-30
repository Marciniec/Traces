package Language;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    private List<String> letters;
    private List<Tuple> cartesianProduct;

    public Alphabet(List<String> letters) {
        this.letters = letters;
        cartesianProduct = new ArrayList<Tuple>();
        setCartesianProduct();
    }

    private void setCartesianProduct() {
        for (String l1 :
                letters) {
            for (String l2 :
                    letters) {
                cartesianProduct.add(new Tuple(l1, l2));
            }
        }
    }

    public List<Tuple> getCartesianProduct() {
        return cartesianProduct;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Tuple tuple :
                cartesianProduct
             ) {
            sb.append(" ").append(tuple.toString());
        }
        return sb.toString();
    }
}
