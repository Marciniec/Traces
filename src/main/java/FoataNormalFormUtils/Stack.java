package FoataNormalFormUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack {
    private List<String> letterStack;

    Stack() {
        letterStack = new ArrayList<>();
    }

    public void push(String element) {
        letterStack.add(element);
    }

    public String pop() {
        String letter = letterStack.get(letterStack.size() - 1);
        letterStack.remove(letterStack.size() - 1);
        return letter;
    }
    public Boolean isEmpty(){
        return letterStack.isEmpty();
    }
    public Boolean isTopALetter(){
        return !isEmpty() && !Objects.equals(letterStack.get(letterStack.size() - 1), "*");
    }
}
