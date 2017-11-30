package Language;

import java.util.List;
import java.util.stream.Collectors;

public class Independence {

    private List<Tuple> independenceList;

    public Independence(List<Tuple> independenceList) {
        this.independenceList = independenceList;
    }

    public List<Tuple> getIndependenceList() {
        return independenceList;
    }
    public List<String> retrieveAllIndependentTo(String letter){
        return independenceList.stream().filter(tuple -> tuple.getX().equals(letter))
                .map(Tuple::getY).collect(Collectors.toList());
    }
}
